package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import com.example.schedule.request.ScheduleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository{
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("password", schedule.getPassword());
        parameters.put("name", schedule.getName());
        parameters.put("contents", schedule.getContents());
        parameters.put("createDate", LocalDateTime.now());
        parameters.put("updateDate", LocalDateTime.now());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(key.longValue(), schedule.getName(),schedule.getContents());
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        return jdbcTemplate.query("SELECT * FROM schedule ORDER BY UPDATEDATE", ScheduleMapper());
    }

    @Override
    public Schedule findScheduleByIdOrElseThrow(Long id) {
        List<Schedule> result = jdbcTemplate.query("SELECT * FROM schedule WHERE ID = ?", ScheduleMapperV2(), id);
        return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dose not exist id = " + id));
    }

    @Override
    public int updateSchedule(Long id, String contents, String name, String updateDate) {
        return jdbcTemplate.update("UPDATE schedule SET CONTENTS = ?, NAME = ?, UPDATEDATE = ? WHERE ID = ?", contents, name, updateDate, id);
    }

    @Override
    public int deleteSchedule(Long id) {
        return jdbcTemplate.update("DELETE FROM schedule WHERE ID = ?", id);
    }

    private RowMapper<ScheduleResponseDto> ScheduleMapper() {
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("contents"),
                        rs.getString("createDate"),
                        rs.getString("updateDate")
                );
            }
        };
    }

    private RowMapper<Schedule> ScheduleMapperV2() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("contents"),
                        rs.getTimestamp("createDate").toLocalDateTime().toLocalDate(),
                        rs.getTimestamp("updateDate").toLocalDateTime().toLocalDate()
                );
            }
        };
    }


}

package com.example.schedule.service;

import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.request.ScheduleRequestDto;
import com.example.schedule.request.ScheduleResponseDto;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository repository;

    public ScheduleServiceImpl(ScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getId(), dto.getPassword(), dto.getName(), dto.getContents());
        return repository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        return repository.findAllSchedules();
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = repository.findScheduleByIdOrElseThrow(id);
        return new ScheduleResponseDto(schedule);
    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, String password, String contents, String name, String updateDate) {
        int update = repository.updateSchedule(id, contents, name, updateDate);

        if(update == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        if(contents == null || name == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The contents and name are required values");
        }

        Schedule schedule = repository.findScheduleByIdOrElseThrow(id);
        ScheduleRequestDto dto = new ScheduleRequestDto(schedule.getId(), schedule.getPassword(), schedule.getName(), schedule.getContents());

        if (!password.equals(dto.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The password is different or not");
        }

        return new ScheduleResponseDto(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        int deleted = repository.deleteSchedule(id);

        if (deleted == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dose not exits id = " + id);
        }

    }


}

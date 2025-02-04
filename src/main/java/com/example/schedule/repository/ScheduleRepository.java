package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import com.example.schedule.request.ScheduleResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository {
    ScheduleResponseDto saveSchedule(Schedule schedule);
    List<ScheduleResponseDto> findAllSchedules(String name, String updateDate);
    Schedule findScheduleByIdOrElseThrow(Long id);
    int updateSchedule(Long id, String contents, String name, String updateDate);
    int deleteSchedule(Long id);
}

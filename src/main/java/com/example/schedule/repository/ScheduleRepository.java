package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import com.example.schedule.request.ScheduleResponseDto;

import java.util.List;

public interface ScheduleRepository {
    ScheduleResponseDto saveSchedule(Schedule schedule);
    List<ScheduleResponseDto> findAllSchedules();
    Schedule findScheduleByIdOrElseThrow(Long id);
    int updateSchedule(Long id, String contents, String name);
}

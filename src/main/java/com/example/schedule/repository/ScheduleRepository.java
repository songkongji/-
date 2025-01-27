package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import com.example.schedule.request.ScheduleResponseDto;

public interface ScheduleRepository {
    ScheduleResponseDto saveSchedule(Schedule schedule);
}

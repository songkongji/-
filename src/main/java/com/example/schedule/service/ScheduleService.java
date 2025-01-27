package com.example.schedule.service;

import com.example.schedule.request.ScheduleRequestDto;
import com.example.schedule.request.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);
    List<ScheduleResponseDto> findAllSchedules();
    ScheduleResponseDto findScheduleById(Long id);
    ScheduleResponseDto updateSchedule(Long id, String password, String contents, String name);
}

package com.example.schedule.controller;

import com.example.schedule.entity.Schedule;
import com.example.schedule.request.ScheduleRequestDto;
import com.example.schedule.request.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules(){
        return new ResponseEntity<>(scheduleService.findAllSchedules(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ){
        Schedule schedule = new Schedule(id, dto.getPassword(), dto.getName(), dto.getContents());
        return new ResponseEntity<>(scheduleService.updateSchedule(id, dto.getPassword(), dto.getContents(), dto.getName(), schedule.getUpdateDate()), HttpStatus.OK);
    }
}

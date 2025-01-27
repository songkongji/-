package com.example.schedule.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private Long id;
    private Long password;
    private String name;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}

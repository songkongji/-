package com.example.schedule.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private Long id;
    private String password;
    private String name;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public ScheduleRequestDto(Long id, String password, String name, String contents) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.contents = contents;
    }
}

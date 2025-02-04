package com.example.schedule.request;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String contents;
    private String createDate;
    private String updateDate;

    public ScheduleResponseDto(Long id, String name, String contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = now.format(formatter);

        this.createDate = formattedDateTime;
        this.updateDate = formattedDateTime;
    }

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.contents = schedule.getContents();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.createDate = schedule.getCreateDate().format(formatter);
        this.updateDate = schedule.getUpdateDate().format(formatter);
    }
}

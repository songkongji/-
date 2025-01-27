package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private Long password;
    private String name;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Schedule(Long id, Long password, String name, String contents){
        this.id = id;
        this.password = password;
        this.name = name;
        this.contents = contents;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public Schedule(Long id, String name, String contents, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}

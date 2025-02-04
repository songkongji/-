package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String password;
    private String name;
    private String contents;
    private LocalDate createDate;
    private LocalDate updateDate;

    public Schedule(Long id, String password, String name, String contents){
        this.id = id;
        this.password = password;
        this.name = name;
        this.contents = contents;
        this.createDate = LocalDate.now();
        this.updateDate = LocalDate.now();
    }

    public Schedule(Long id, String name, String contents, LocalDate createDate, LocalDate updateDate) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}

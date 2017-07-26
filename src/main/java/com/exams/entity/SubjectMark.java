package com.exams.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubjectMark {
    private String title;
    private Integer mark;

    @Override
    public String toString() {
        return "SubjectMark{" +
                "title='" + title + '\'' +
                ", mark=" + mark +
                '}';
    }
}

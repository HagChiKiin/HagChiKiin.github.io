package com.example.demo_task.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    TODO("TODO","To Do"),
    IN_PROGRESS("IN_PROGRESS","In progress"),
    REVIEWING("REVIEWING","Reviewing"),
    DONE("DONE","Done");
    public String code;
    public String name;
}

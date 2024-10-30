package com.example.choresplit;

public class Chore {
    private String task;
    private String day;
    private String assignedPerson;

    public Chore(String task, String day, String assignedPerson) {
        this.task = task;
        this.day = day;
        this.assignedPerson = assignedPerson;
    }

    public String getTask() {
        return task;
    }

    public String getDay() {
        return day;
    }

    public String getAssignedPerson() {
        return assignedPerson;
    }

    public void setAssignedPerson(String assignedPerson) {
        this.assignedPerson = assignedPerson;
    }
}


package com.sofi.bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class Batch {

    // Field Declarations
    private int bid;
    private String instructor;
    private Date date;
    private String schedule;
    private Time time;

    // Non-parameterized constructor
    public Batch() {
    }

    // Parameterized constructor
    public Batch(int bid, String instructor, Date date, String schedule, Time time) {
        this.bid = bid;
        this.instructor = instructor;
        this.date = date;
        this.schedule = schedule;
        this.time = time;
    }

    // Getters and Setters
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Batch [bid=" + bid + ", instructor=" + instructor + ", date=" + date + ", schedule=" + schedule
                + ", time=" + time + "]";
    }
}

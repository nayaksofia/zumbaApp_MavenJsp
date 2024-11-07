package com.sofi.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Batch {
	
	//Field Declaration
	private int bid;
	
	private String instructor;
	
	private LocalDate date;
	
	private String schedule;
	
	private LocalTime time;

	//Non-parameterized constructor
	
	public Batch() {
		
	}
	
	//Parameterized constructor
	public Batch(int bid, String instructor, LocalDate date, String schedule, LocalTime time) {
		
		this.bid = bid;
		this.instructor = instructor;
		this.date = date;
		this.schedule = schedule;
		this.time = time;
	}

	
	//Generate getter and setter 
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


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}


	//Generate toString method
	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", instructor=" + instructor + ", date=" + date + ", schedule=" + schedule
				+ ", time=" + time + "]";
	}

	

	

	

}

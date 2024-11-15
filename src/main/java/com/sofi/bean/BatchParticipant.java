package com.sofi.bean;

public class BatchParticipant {

	//Field declaration
	private int pid;
    private int bid;
  
    //Generate non-parameterized constructor
	public BatchParticipant() {
		
	}
	
	//Generate parameterized constructor
	public BatchParticipant(int pid, int bid) {
		
		this.pid = pid;
		this.bid = bid;
		
	}
	
	//Generate getter and setter
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
	//Generate toString method
	@Override
	public String toString() {
		return "ParticipantBatch [pid=" + pid + ", bid=" + bid + ", pname=" + "]";
	}
    
    
	
	
}

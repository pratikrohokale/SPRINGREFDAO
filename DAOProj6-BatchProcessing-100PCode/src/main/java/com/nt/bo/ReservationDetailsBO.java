package com.nt.bo;

import java.io.Serializable;

public class ReservationDetailsBO {
	private int pid;
	private String name;
	private int age;
	private String boardingFrom;
	private String  destination;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBoardingFrom() {
		return boardingFrom;
	}
	public void setBoardingFrom(String boardingFrom) {
		this.boardingFrom = boardingFrom;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

}

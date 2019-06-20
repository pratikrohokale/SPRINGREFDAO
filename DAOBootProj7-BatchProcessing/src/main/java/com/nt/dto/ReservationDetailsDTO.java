package com.nt.dto;

import java.io.Serializable;

public class ReservationDetailsDTO implements Serializable {
	private String name;
	private int age;
	private String boardingFrom;
	private String  destination;
	
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

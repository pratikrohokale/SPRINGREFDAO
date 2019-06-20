package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private int no;
	private String ename;
	private String job;
	private int salary;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [no=" + no + ", ename=" + ename + ", job=" + job + ", salary=" + salary + "]";
	}
	
	

}

package com.jbac.course.model;



public class Course {
	
	
	private String name;
	
	private int duration;
	
	private String hours;
	
	public Course() {
	}

	public Course(String name, int duration, String hours) {
		this.name = name;
		this.duration = duration;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}




}

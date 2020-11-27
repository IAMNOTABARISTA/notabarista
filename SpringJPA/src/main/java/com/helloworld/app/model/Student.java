package com.helloworld.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String courseString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseString() {
		return courseString;
	}

	public void setCourseString(String courseString) {
		this.courseString = courseString;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", courseString=" + courseString + "]";
	}

}

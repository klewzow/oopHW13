package com.gmail.klewzow;

import java.util.Arrays;
import java.util.Comparator;

public class Student extends Human implements Comparable {

	private int groupName;
	private int course;

	public Student(String name, String surename, int age, boolean gender, String nacionality, long iPn, int groupName,
			int course) {
		super(name, surename, age, gender, nacionality, iPn);
		this.groupName = groupName;
		this.course = course;
	}

	public Student() {
		super();
	}

	@Override
	public int compareTo(Object o) {
		Student anotherStudent = (Student) o;
		return (int) (this.getAge() - anotherStudent.getAge());
	}

	public int getGroupName() {
		return groupName;
	}

	public void setGroupName(int groupName) {
		this.groupName = groupName;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	@Override
	public boolean isGender() {
		return super.isGender();
	}

	@Override
	public int getAge() {
		return super.getAge();
	}

	@Override
	public String toString() {
		return super.toString() + "   groupName=" + groupName + ", course=" + course + "]";
	}

}

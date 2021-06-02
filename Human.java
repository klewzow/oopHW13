package com.gmail.klewzow;

public class Human {
	private String name;
	private String surename;
	private int age;
	private boolean gender;
	private String nacionality;
	private long iPn;

	public Human(String name, String surename, int age, boolean gender, String nacionality, long iPn) {
		super();
		this.name = name;
		this.surename = surename;
		this.age = age;
		this.gender = gender;
		this.nacionality = nacionality;
		this.iPn = iPn;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public long getiPn() {
		return iPn;
	}

	public void setiPn(long iPn) {
		this.iPn = iPn;
	}

	@Override
	public String toString() {

		return "Human [name=" + name + ", surename=" + surename + ", age=" + age + ", gender=" + gender
				+ ", nacionality=" + nacionality + ", iPn=" + iPn  ;
	}

}

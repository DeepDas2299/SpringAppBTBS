package com.mph.entity;

import javax.persistence.Embeddable;

/**
 * This Model is for the Passenger class
 * @author Divya G
 * @version 1.0
 */
@Embeddable
public class Passenger {

	private String name;
	private String gender;
	private int age;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object arg0) {
		return ((this.name.equals(((Passenger) arg0).name)) && (this.gender.equals(((Passenger) arg0).gender))
				&& (this.age == ((Passenger) arg0).age));
	}

	@Override
	public int hashCode() {
		int hash = 5;
        hash = (int) (89 * hash + (this.age >= 0 ? this.age: 0));
        hash = 89 * hash + (int) (this.age ^ (this.age >>> 32));
        hash = (int) (89 * hash + this.age);
        return hash;
	}
}

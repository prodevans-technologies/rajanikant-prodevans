package com.prodevans.comparable;

public class StudentComparable implements Comparable<StudentComparable>{
	private int roll;
	private String name;
	private int std;
	public StudentComparable(int roll, String name, int std) {
		super();
		this.roll = roll;
		this.name = name;
		this.std = std;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int compareTo(StudentComparable st) {
		if(st.getStd() > getStd()) {
			return -1;
		}
		else if(st.getStd() == getStd())  {
			if(st.getRoll() > getRoll())
			{
				return -1;
			}
			else
			{
				return 1;
			}
			
		}
		else {
			return 1;
		}
	}
	@Override
	public String toString() {
		return "StudentComparable [roll=" + roll + ", name=" + name + ", std=" + std + "]";
	}
	
}

package com.ITAcademy.restproject.enumeration;

public enum JobsEnum {

	burglar(1500), thief(1800), baker(1000), painter(1300);

	private final int jobSalary;

	JobsEnum(int jobSalary) {
		this.jobSalary = jobSalary;
	}

	public int getJobSalary() {
		return this.jobSalary;
	}

}

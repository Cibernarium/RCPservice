package com.ITAcademy.restproject.model;

import com.ITAcademy.restproject.enumeration.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Employee {

	private @Id @GeneratedValue Long id;

	private String name;

	private String job;

	private int salary;
	
	

	public Employee() {
	
	}

	public Employee(String name, String job, int salary) {
		super();
		this.name = name;
		this.job = job;
		this.salary =salary;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return JobsEnum.valueOf(job).getJobSalary();
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [job=" + job + "]";
	}

	


}
package com.ITAcademy.restproject.exception;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(Long id) {

		super("Could not find employee " + id);

	}

	public EmployeeNotFoundException(String job) {

		super("Could not find employee " + job);

	}
}

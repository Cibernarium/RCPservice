package com.ITAcademy.restproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.restproject.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	Optional<List<Employee>> findByJob(String job);
		
	
		
	}

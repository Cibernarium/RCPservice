package com.ITAcademy.restproject.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.restproject.enumeration.JobsEnum;
import com.ITAcademy.restproject.exception.EmployeeNotFoundException;
import com.ITAcademy.restproject.model.Employee;
import com.ITAcademy.restproject.repository.EmployeeRepository;

@RestController

public class EmployeeController {

	private final EmployeeRepository repository;

	EmployeeController(EmployeeRepository repository) {

		this.repository = repository;

	}

// Aggregate root
//localhost:8080/employees
	@GetMapping("/employees")

	List<Employee> all() {

		return repository.findAll();

	}// localhost:8080/employees

	@PostMapping("/employees")

	Employee newEmployee(@RequestBody Employee newEmployee) throws RuntimeException {

		for (JobsEnum job : JobsEnum.values()) {
			if (newEmployee.getJob().toString().equals(job.name())) {
				return repository.save(newEmployee);
			}
		}
		throw new ServiceException("Job not found");
	}

// Single item
//localhost:8080/employees/8
	@GetMapping("/employees/{id}")

	Employee one(@PathVariable Long id) {

		return repository.findById(id)

				.orElseThrow(() -> new EmployeeNotFoundException(id));

	}

	// localhost:8080/employees/thief
	@GetMapping("/employees/{id}/{job}")

	List<Employee> Employee(@PathVariable String job) {

		return repository.findByJob(job)

				.orElseThrow(() -> new EmployeeNotFoundException(job));

	}

//localhost:8080/employes/4
	@PutMapping("/employees/{id}")

	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return repository.findById(id)

				.map(employee -> {

					employee.setName(newEmployee.getName());

					employee.setJob(newEmployee.getJob());

					return repository.save(employee);

				})

				.orElseGet(() -> {

					newEmployee.setId(id);

					return repository.save(newEmployee);

				});

	}

	@DeleteMapping("/employees/{id}")

	void deleteEmployee(@PathVariable Long id) {

		repository.deleteById(id);

	}

}
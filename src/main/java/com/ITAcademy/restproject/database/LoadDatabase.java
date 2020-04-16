package com.ITAcademy.restproject.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ITAcademy.restproject.enumeration.JobsEnum;
import com.ITAcademy.restproject.model.Employee;
import com.ITAcademy.restproject.repository.EmployeeRepository;

@Configuration

public class LoadDatabase {

@Bean

CommandLineRunner initDatabase(EmployeeRepository repository) {

return args -> {

System.out.println("Preloading Data to memoryDatabase");

repository.save(new Employee("Bilbo Baggins", "burglar", JobsEnum.burglar.getJobSalary())) ;

repository.save(new Employee("Frodo Baggins", "thief", JobsEnum.thief.getJobSalary()));

repository.save(new Employee("Daniel Mingella", "baker",JobsEnum.baker.getJobSalary()));

repository.save(new Employee("Cristian Villegas", "painter",JobsEnum.painter.getJobSalary()));

System.out.println("Data loaded");

};

}

}
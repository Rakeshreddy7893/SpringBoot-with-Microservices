package com.recykal;

import com.recykal.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

	ConfigurableApplicationContext context =SpringApplication.run(Application.class, args);
	EmployeeService employeeService=context.getBean(EmployeeService.class);

//	employeeService.getEmpWithSort("empName");
// employeeService.getEmpWithPagination(3,3);
employeeService.getEmployeeByQBE();

	}

}

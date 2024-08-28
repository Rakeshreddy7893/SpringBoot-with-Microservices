package com.recykal.service;

import com.recykal.entity.Employee;
import com.recykal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void getEmployeeByQBE(){
        Employee emp = new Employee();
        //If user select dept the set dept value to entity
        emp.setEmpDept("IT");
        emp.setEmpGender("Male");
        emp.setEmpName("John Doe");
        Example<Employee>of=Example.of(emp);
        List<Employee>findAll=employeeRepository.findAll(of);
        findAll.forEach(System.out::println);
    }

    public void getEmpWithSort(String column){
        Iterable<Employee> emp= employeeRepository.findAll(Sort.by(column).descending());
        emp.forEach(e-> System.out.println(e));
    }

    public  void getEmpWithPagination(int pageSize,int pageNo){
        //In web application Page number will come from ui and page size will be fixed
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        List<Employee> content = employees.getContent();
        content.forEach(System.out::println);
    }



}

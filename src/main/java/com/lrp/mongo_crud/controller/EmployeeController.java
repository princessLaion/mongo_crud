package com.lrp.mongo_crud.controller;

import com.lrp.mongo_crud.model.Employee;
import com.lrp.mongo_crud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveOrUpdate(@RequestBody Employee emp) {
        return
                new ResponseEntity<Employee>(employeeService.saveOrUpdate(emp), HttpStatus.CREATED);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("empId") int empId) {
        return new ResponseEntity<Employee>(employeeService.findEmployee(empId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") int employeeId) {
        Employee emp = employeeService.findEmployee(employeeId);
        employeeService.deleteEmployee(emp);

        return
                new ResponseEntity<String>(String.format("Employee %s was deleted.", emp.getName()), HttpStatus.ACCEPTED);
    }
}

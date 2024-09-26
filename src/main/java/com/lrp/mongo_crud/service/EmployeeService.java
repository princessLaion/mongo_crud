package com.lrp.mongo_crud.service;

import com.lrp.mongo_crud.model.Employee;
import com.lrp.mongo_crud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Employee saveOrUpdate(Employee emp) {
        return repository.save(emp);
    }

    public List<Employee> getAllEmployee() {
        //return List.of(new Employee(1, "John Smith", "Australia"));
        return repository.findAll();
    }

    public Employee findEmployee(int empId) {
        return repository.findById(empId).orElseThrow(() -> new IllegalStateException("not found"));
    }

    public void deleteEmployee(Employee employee) {
        repository.delete(employee);

    }
}

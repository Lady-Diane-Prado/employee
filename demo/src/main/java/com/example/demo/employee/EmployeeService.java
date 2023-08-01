package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Email is taken!");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("employee with Id " + employeeId + " does not exists. ");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String full_name, String email) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("Employee with id" + employeeId + "does not exist"));

        if (full_name != null &&
                full_name.length() > 0 &&
                        !Objects.equals(employee.getFull_name(), full_name)) {
            employee.setFull_name(full_name);
        }
            if (email != null &&
                email.length() > 0 &&
                    !Objects.equals(employee.getEmail(), email)) {
                Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);
                if (employeeOptional.isPresent()) {
                    throw new IllegalStateException("Email is already taken.");
                }
                employee.setEmail(email);
            }
    }
}

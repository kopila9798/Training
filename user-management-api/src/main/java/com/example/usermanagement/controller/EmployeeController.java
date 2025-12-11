package com.example.usermanagement.controller;

import com.example.usermanagement.entity.Employee;
import com.example.usermanagement.repository.EmployeeRepository;
import com.example.usermanagement.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "false")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Employee payload) {
        if (payload.getEmail() != null && employeeRepository.existsByEmail(payload.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        Employee saved = employeeRepository.save(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee payload) {
        Employee existing = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
        existing.setName(payload.getName());
        existing.setEmail(payload.getEmail());
        existing.setPayroll(payload.getPayroll());
        existing.setDepartment(payload.getDepartment());
        existing.setRole(payload.getRole());
        existing.setJoiningDate(payload.getJoiningDate());
        existing.setContractType(payload.getContractType());
        return employeeRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Employee existing = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
        employeeRepository.delete(existing);
    }
}

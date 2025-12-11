package com.example.usermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "employees", indexes = {
        @Index(name = "idx_employees_email", columnList = "email", unique = true)
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @Size(max = 50)
    private String payroll;

    @Size(max = 50)
    private String department;

    @Size(max = 100)
    private String role;

    private LocalDate joiningDate;

    @Size(max = 30)
    private String contractType; // e.g., Full-time, Part-time, Internship, Freelance

    public Employee() {}

    public Employee(Long id, String name, String email, String payroll, String department, String role, LocalDate joiningDate, String contractType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.payroll = payroll;
        this.department = department;
        this.role = role;
        this.joiningDate = joiningDate;
        this.contractType = contractType;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPayroll() { return payroll; }
    public void setPayroll(String payroll) { this.payroll = payroll; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public String getContractType() { return contractType; }
    public void setContractType(String contractType) { this.contractType = contractType; }
}

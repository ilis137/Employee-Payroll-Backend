package com.employeepayrollapp.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="employee_payroll_data")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class EmployeePayrollData {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long employeeId;
    @NonNull
    private String name;

    @NonNull
    private long salary;
}

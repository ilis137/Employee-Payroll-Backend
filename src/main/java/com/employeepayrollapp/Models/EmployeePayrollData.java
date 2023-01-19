package com.employeepayrollapp.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employee_payroll_data")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class EmployeePayrollData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long employeeId;
    @NonNull
    private String name;
    @NonNull
    private long salary;

    @NonNull
    public String gender;

    @NonNull
    public LocalDate startDate;

    @NonNull
    public String note;

    @NonNull
    public String profilePic;

    @NonNull
    @ElementCollection
    @CollectionTable(name="employee_department",joinColumns = @JoinColumn(name="id"))
    @Column(name="department")
    public List<String> departments;
}


package com.employeepayrollapp.Repository;

import com.employeepayrollapp.Models.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Long> {
}

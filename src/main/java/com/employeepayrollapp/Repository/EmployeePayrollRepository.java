package com.employeepayrollapp.Repository;

import com.employeepayrollapp.Models.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Long> {

    @Query(value="select * from employee_payroll_data,employee_department where employee_id=id and department=:department",nativeQuery=true)
    List<EmployeePayrollData> findEmployeePayrollByData(String department);
}

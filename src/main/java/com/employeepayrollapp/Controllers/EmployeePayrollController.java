package com.employeepayrollapp.Controllers;


import com.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.employeepayrollapp.DTO.ResponseDTO;
import com.employeepayrollapp.Models.EmployeePayrollData;
import com.employeepayrollapp.Services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService employeePayrollService;
    @GetMapping(value = {"/",""})
    public ResponseEntity<String> getEmployeePayrollData(){
//        EmployeePayrollData empData=new EmployeePayrollData("pankaj",30000);
//        ResponseDTO response=new ResponseDTO("successfully fetched payroll data",empData);
        return new ResponseEntity<>("successfully fetched payroll data", HttpStatus.OK);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<String> getEmployeePayrollDataById(@PathVariable long empId){
        return new ResponseEntity<>("successfully fetched payroll data for employee id "+empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployeePayroll(@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<>("successfully created employee payroll data for "+empPayrollDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> DeleteEmployeePayrollData(@PathVariable long empId){
        return new ResponseEntity<>("successfully deleted employee payroll data for employee id "+empId, HttpStatus.OK);
    }

    @PutMapping ("/update/{empId}")
    public ResponseEntity<String> updateEmployeePayrollData(@PathVariable long empId,@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<>("successfully updated employee payroll data for employee id "+empId, HttpStatus.OK);
    }
}

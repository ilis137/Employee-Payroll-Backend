package com.employeepayrollapp.Controllers;


import com.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.employeepayrollapp.DTO.ResponseDTO;
import com.employeepayrollapp.Exceptions.EmployeePayrollNotFoundException;
import com.employeepayrollapp.Models.EmployeePayrollData;
import com.employeepayrollapp.Services.IEmployeePayrollService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        ResponseDTO response=new ResponseDTO("successfully fetched payroll data",employeePayrollService.getAllEmployeePayroll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable long empId) throws EmployeePayrollNotFoundException {
        ResponseDTO response=new ResponseDTO("successfully fetched payroll data for employee id "+empId,employeePayrollService.getEmployeePayrollById(empId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayroll(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){

        ResponseDTO response=new ResponseDTO("successfully created employee payroll data",employeePayrollService.createEmployeePayroll(empPayrollDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> DeleteEmployeePayrollData(@PathVariable long empId){
        employeePayrollService.deleteEmployeePayrollById(empId);
        ResponseDTO response=new ResponseDTO("successfully deleted employee payroll data for employee id "+empId,true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping ("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable long empId,@Valid @RequestBody  EmployeePayrollDTO empPayrollDTO)  throws EmployeePayrollNotFoundException {
        ResponseDTO response=new ResponseDTO("successfully updated employee payroll data for employee id "+empId,employeePayrollService.updateEmployeePayrollById(empId,empPayrollDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByDepartment(@PathVariable String department) throws EmployeePayrollNotFoundException{
        ResponseDTO response=new ResponseDTO("successfully fetched payroll data by department "+department,employeePayrollService.getEmployeePayrollByDepartment(department));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

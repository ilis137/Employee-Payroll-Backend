package com.employeepayrollapp.Exceptions;

public class EmployeePayrollNotFoundException extends RuntimeException{
    public EmployeePayrollNotFoundException(String message){
        super (message);
    }
}

package com.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppBackendApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(EmployeePayrollAppBackendApplication.class, args);
        log.info("Employee Payroll App Started in {} Environment", context.getEnvironment().getProperty("environment"));
        log.info("Employee Payroll DB User is {} Environment", context.getEnvironment().getProperty("spring.datasource.username"));
    }

}

package com.employeepayrollapp.Services;

import com.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.employeepayrollapp.Exceptions.EmployeePayrollNotFoundException;
import com.employeepayrollapp.Models.EmployeePayrollData;
import com.employeepayrollapp.Repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    @Override
    public EmployeePayrollDTO createEmployeePayroll(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empPayroll = new EmployeePayrollData(employeePayrollDTO.getName(), employeePayrollDTO.getSalary(), employeePayrollDTO.getGender(), employeePayrollDTO.getStartDate(), employeePayrollDTO.getProfilePic(), employeePayrollDTO.getNote(), employeePayrollDTO.getDepartments());
        empPayroll = employeePayrollRepository.save(empPayroll);
        log.debug(String.valueOf(empPayroll));
        return modelMapper.map(empPayroll, EmployeePayrollDTO.class);
    }

    @Override
    public EmployeePayrollDTO getEmployeePayrollById(long empId) throws EmployeePayrollNotFoundException {
        EmployeePayrollData employeePayrollData = employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeePayrollNotFoundException("Employee payroll not found for employee id " + empId));
        log.debug(String.valueOf(employeePayrollData));
        return modelMapper.map(employeePayrollData, EmployeePayrollDTO.class);
    }

    @Override
    public List<EmployeePayrollDTO> getAllEmployeePayroll() {
        List<EmployeePayrollData> employeePayrollList = employeePayrollRepository.findAll();
        List<EmployeePayrollDTO> employeePayrollDTOList = employeePayrollList.stream().map(empPayroll -> modelMapper.map(empPayroll, EmployeePayrollDTO.class)).collect(Collectors.toList());
        return employeePayrollDTOList;
    }

    @Override
    public EmployeePayrollDTO updateEmployeePayrollById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeePayrollNotFoundException {

        EmployeePayrollData employeePayrollData = employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeePayrollNotFoundException("Employee payroll not found for employee id " + empId));
        employeePayrollData.setName(employeePayrollDTO.getName());
        employeePayrollData.setSalary(employeePayrollDTO.getSalary());
        employeePayrollData.setNote(employeePayrollDTO.getNote());
        employeePayrollData.setGender(employeePayrollDTO.getGender());
        employeePayrollData.setDepartments(employeePayrollDTO.getDepartments());
        employeePayrollData.setProfilePic(employeePayrollDTO.getProfilePic());
        employeePayrollData.setStartDate(employeePayrollDTO.getStartDate());
        employeePayrollData = employeePayrollRepository.save(employeePayrollData);
        return modelMapper.map(employeePayrollData, EmployeePayrollDTO.class);

    }

    @Override
    public void deleteEmployeePayrollById(long empId) {
        employeePayrollRepository.deleteById(empId);
    }
}

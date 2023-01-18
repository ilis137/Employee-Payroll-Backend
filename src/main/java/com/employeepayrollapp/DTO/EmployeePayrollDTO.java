package com.employeepayrollapp.DTO;


import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {
    @Nullable
    public long id;
    @NonNull
    public String name;
    @NonNull
    public long salary;
}

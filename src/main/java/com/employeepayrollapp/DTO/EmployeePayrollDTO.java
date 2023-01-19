package com.employeepayrollapp.DTO;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="employee name invalid")
    public String name;
    @NonNull
    @Min(value=500,message="Minimum wage should be at least 500")
    public long salary;
}

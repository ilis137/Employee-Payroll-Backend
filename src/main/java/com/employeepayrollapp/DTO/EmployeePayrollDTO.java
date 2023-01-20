package com.employeepayrollapp.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {
    @Nullable
    public long id;
    @NonNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "employee name invalid")
    public String name;
    @NonNull
    @Min(value = 500, message = "Minimum wage should be at least 500")
    public long salary;

    @Pattern(regexp="male|female",message="gender needs to be male or female")
    public String gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd MMM yyyy")
    @NotNull(message="StartDate should not be empty")
    @PastOrPresent(message="startDate should be past or todays date")
    public LocalDate startDate;

    @NotBlank(message="Note cannot be empty")
    public String note;

    @NotBlank(message="profile pic cannot be empty")
    public String profilePic;

    @NotNull(message="department should not be empty")
    public List<String> departments;
}

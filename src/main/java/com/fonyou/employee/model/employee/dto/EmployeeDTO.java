package com.fonyou.employee.model.employee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder()
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = -306571471783579597L;

    private Long id;

    @NotEmpty(message = "Firstname cannot be empty")
    @Size(max=255, min=3, message="FirstName can't be shorter than 3 or bigger than 255")
    private String firstname;

    @NotEmpty(message = "Lastname cannot be empty")
    @Size(max=255, min=3, message="Lastname can't be shorter than 3 or bigger than 255")
    private String lastname;

    @NotNull
    @PastOrPresent(message="Date start value cannot is in the future")
    private LocalDate dateStart;

    @PastOrPresent(message="Date end value cannot is in the future")
    private LocalDate dateEnd;

    @Positive(message="Base Salary cannot be minor or equal than 0")
    private float baseSalary;
}
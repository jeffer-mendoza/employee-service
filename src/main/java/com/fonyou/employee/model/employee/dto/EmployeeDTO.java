package com.fonyou.employee.model.employee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


import java.util.Date;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder()
class EmployeeDTO {
    private String firstname;
    private String lastname;
    private Date dateStart;
    private Date dateEnd;
    private float baseSalary;
}
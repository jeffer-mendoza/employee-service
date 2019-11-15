package com.fonyou.employee.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class PayEmployeeDTO {
    private Long id;
    @Min(value = 1, message = "month cannot be minor than 1")
    @Max(value = 12, message = "month cannot be older than 12")
    private short month;

    @Min(value = 1990, message = "year cannot be minor than 1990")
    @Max(value = 2050, message = "year cannot be older than 2050")
    private short year;
}

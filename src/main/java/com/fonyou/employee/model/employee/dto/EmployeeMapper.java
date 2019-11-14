package com.fonyou.employee.model.employee.dto;

import com.fonyou.employee.model.employee.Employee;

public class EmployeeMapper {

    public static EmployeeDTO toEmployeeDto(final Employee employee){
        return EmployeeDTO.builder()
            .firstname(employee.getFirstname())
            .lastname(employee.getLastname())
            .dateStart(employee.getDateStart())
            .dateEnd(employee.getDateEnd())
            .baseSalary(employee.getBaseSalary())
            .build();
    }

    public static Employee toEmployee(final EmployeeDTO employeeDTO) {
        return Employee.builder()
            .firstname(employeeDTO.getFirstname())
            .lastname(employeeDTO.getLastname())
            .dateStart(employeeDTO.getDateStart())
            .dateEnd(employeeDTO.getDateEnd())
            .baseSalary(employeeDTO.getBaseSalary())
            .build();
    }
}

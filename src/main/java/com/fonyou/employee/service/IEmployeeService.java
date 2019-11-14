package com.fonyou.employee.service;

import com.fonyou.employee.model.employee.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO findById(Long id);

    EmployeeDTO create(EmployeeDTO employeeDTO);

    void update(EmployeeDTO employeeDTO);

    void delete(Long id);
}

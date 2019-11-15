package com.fonyou.employee.service;

import com.fonyou.employee.dto.PayEmployeeDTO;
import com.fonyou.employee.exception.InternalErrorException;
import com.fonyou.employee.exception.ResourceNotFoundException;
import com.fonyou.employee.model.employee.dto.EmployeeDTO;

import java.text.ParseException;
import java.util.List;

public interface IEmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO findById(Long id) throws ResourceNotFoundException;

    EmployeeDTO create(EmployeeDTO employeeDTO);

    void update(EmployeeDTO employeeDTO);

    void delete(Long id);

    float pay(PayEmployeeDTO payEmployeeDTO) throws ResourceNotFoundException, InternalErrorException;
}

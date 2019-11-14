package com.fonyou.employee.service;

import com.fonyou.employee.model.employee.Employee;
import com.fonyou.employee.model.employee.dto.EmployeeDTO;
import com.fonyou.employee.model.employee.dto.EmployeeMapper;
import com.fonyou.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<EmployeeDTO> findAll() {
        return repository.findAll().stream().map(new Function<Employee, EmployeeDTO>() {
            @Override
            public EmployeeDTO apply(Employee employee) {
                return EmployeeMapper.toEmployeeDto(employee);
            }
        }).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Long id) {
        return EmployeeMapper.toEmployeeDto(repository.findById(id).get());
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        return EmployeeMapper.toEmployeeDto(repository.save(EmployeeMapper.toEmployee(employeeDTO)));
    }

    @Override
    public void update(EmployeeDTO employeeDTO) {
        repository.save(EmployeeMapper.toEmployee(employeeDTO));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

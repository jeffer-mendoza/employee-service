package com.fonyou.employee.service;

import com.fonyou.employee.dto.PayEmployeeDTO;
import com.fonyou.employee.exception.InternalErrorException;
import com.fonyou.employee.exception.ResourceNotFoundException;
import com.fonyou.employee.model.employee.Employee;
import com.fonyou.employee.model.employee.dto.EmployeeDTO;
import com.fonyou.employee.model.employee.dto.EmployeeMapper;
import com.fonyou.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
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
    public EmployeeDTO findById(Long id) throws ResourceNotFoundException {
        final Optional optional = repository.findById(id);
        if(!optional.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return EmployeeMapper.toEmployeeDto((Employee)optional.get());
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

    @Override
    public float pay(PayEmployeeDTO payEmployeeDTO)
            throws ResourceNotFoundException, InternalErrorException {
        Employee employee = EmployeeMapper.toEmployee(findById(payEmployeeDTO.getId()));

        try {
            return employee.calculateSalary(payEmployeeDTO.getMonth(), payEmployeeDTO.getYear());
        } catch (ParseException e) {
           throw new InternalErrorException();
        }
    }
}

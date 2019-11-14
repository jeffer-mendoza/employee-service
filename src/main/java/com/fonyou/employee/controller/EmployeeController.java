package com.fonyou.employee.controller;

import com.fonyou.employee.exception.ResourceNotFoundException;
import com.fonyou.employee.model.employee.dto.EmployeeDTO;
import com.fonyou.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @GetMapping
    public List<EmployeeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public EmployeeDTO findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO create(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return service.create(employeeDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @Valid @RequestBody EmployeeDTO employeDTO)
            throws ResourceNotFoundException {
        RestPreconditions.checkFound(service.findById(id));
        service.update(employeDTO);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        RestPreconditions.checkFound(service.findById(id));
        service.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO pay(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return service.create(employeeDTO);
    }
}

package com.testApp.springApp.controller;


import com.testApp.springApp.dto.EmployeeDto;
import com.testApp.springApp.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/emp")
public class EmpAuthController {


    private EmployeeService employeeService;

    public EmpAuthController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("register")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }


}

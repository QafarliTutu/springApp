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

    @PostMapping("create")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/find/{id}")
    public EmployeeDto findById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PutMapping("/update/{id}")
    public EmployeeDto updateEmployee(@PathVariable("id") Long id,
                                      @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id,employeeDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}

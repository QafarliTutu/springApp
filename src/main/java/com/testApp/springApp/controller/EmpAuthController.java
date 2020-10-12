package com.testApp.springApp.controller;


import com.testApp.springApp.payload.request.EmployeeRegisterRequest;
import com.testApp.springApp.services.EmpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/emp")
public class EmpAuthController {


    private EmpService empService;

    public EmpAuthController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping("register")
    public ResponseEntity<?> EmpRegister(@RequestBody EmployeeRegisterRequest regRequest) {
        return empService.EmpRegister(regRequest);
    }


}

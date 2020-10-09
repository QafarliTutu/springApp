package com.testApp.springApp.controller;


import com.testApp.springApp.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public String post() {
        testService.test("Nicat");
        return "Saved";
    }

    @GetMapping("find")
    public String get() {
        testService.find(1);
        return "Found";
    }

}

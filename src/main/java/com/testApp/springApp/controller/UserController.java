package com.testApp.springApp.controller;

import com.testApp.springApp.dto.UserDto;
import com.testApp.springApp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/user")
@RequiredArgsConstructor
public class UserController {


    private UserService userService;


    @PostMapping("create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }


    @PutMapping("update/{id}")
    public UserDto updateEmployee(@PathVariable("id") Long id,
                                  @RequestBody UserDto userDto){
        return userService.updateUser(id,userDto);
    }

    @GetMapping("find/{id}")
    public UserDto findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }



}

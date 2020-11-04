package com.testApp.springApp.services;


import com.testApp.springApp.dto.EmployeeDto;
import com.testApp.springApp.dto.UserDto;
import com.testApp.springApp.exceptions.UserNotFoundEx;
import com.testApp.springApp.model.Education;
import com.testApp.springApp.model.Employee;
import com.testApp.springApp.model.User;

import com.testApp.springApp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final EmployeeService employeeService;
    private final EmailSenderService emailSenderService;
    private final UserRepo userRepo;

    public UserDto createUser(UserDto userDto){
        //find and convert EmployeeDto to Employee
        EmployeeDto employeeDto = employeeService.findById(userDto.getEmployeeId());
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        System.out.println(employee);

        //convert UserDto to User
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setEmployee(employee);
        System.out.println(user);

        //generate and send password
        String password = generatePassword();
        //sendEmail(employee.getEmail(),password);

        //encode and set Password
        user.setPassword(password);
        userRepo.save(user);
        BeanUtils.copyProperties(user,userDto);
        System.out.println(userDto);
        return userDto;
    }

    private void sendEmail(String email,String password) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Password.");
        mailMessage.setFrom("myfirstcalculatorapp@gmail.com");
        mailMessage.setText("Your password: " + password);
        emailSenderService.sendEmail(mailMessage);
    }

    private String generatePassword() {//TODO SHOULD BE IMPLEMENTED!
        return "123";
    }

    public UserDto findById(Long id) {
        UserDto userDto = new UserDto();
        Optional<User> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            BeanUtils.copyProperties(byId.get(), userDto);
            return userDto;
        } else throw new UserNotFoundEx();
    }

    public UserDto updateUser(Long id, UserDto userDto){
        User user = new User();
        user.setId(id);
        BeanUtils.copyProperties(userDto,user);
        userRepo.save(user);
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    public void deleteUser(Long id){
        //userRepo.deleteById(id);
        Optional<User> byId = userRepo.findById(id);
        if(byId.isPresent() && byId.get().getStatus()){
            User education = byId.get();
            education.setStatus(false);
            education.setDeletedAt(LocalDateTime.now());
            userRepo.save(education);
        }
    }
}
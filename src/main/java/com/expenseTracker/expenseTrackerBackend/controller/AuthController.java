package com.expenseTracker.expenseTrackerBackend.controller;

import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.dto.UserRegistrationDto;
import com.expenseTracker.expenseTrackerBackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseDto newUser(@RequestBody UserRegistrationDto userDto){
        return userService.saveUser(userDto);
    }
}

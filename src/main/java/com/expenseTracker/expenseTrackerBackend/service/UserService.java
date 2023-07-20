package com.expenseTracker.expenseTrackerBackend.service;

import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.dto.UserRegistrationDto;
import com.expenseTracker.expenseTrackerBackend.models.Users;

public interface UserService {
    ResponseDto saveUser(UserRegistrationDto userDto);

    Users findById(int id);
}

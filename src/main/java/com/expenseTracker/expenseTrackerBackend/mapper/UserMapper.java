package com.expenseTracker.expenseTrackerBackend.mapper;

import com.expenseTracker.expenseTrackerBackend.dto.UserRegistrationDto;
import com.expenseTracker.expenseTrackerBackend.models.Users;

public class UserMapper {

    public static Users mapToUser(UserRegistrationDto userRegistrationDto){
        Users users=Users.builder()
                .email(userRegistrationDto.getEmail())
                .password(userRegistrationDto.getPassword())
                .name(userRegistrationDto.getName()).build();
        users.setTotalBalance(0);
        return users;
    }


}

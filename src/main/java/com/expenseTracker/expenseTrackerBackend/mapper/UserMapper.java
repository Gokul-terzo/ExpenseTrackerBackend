package com.expenseTracker.expenseTrackerBackend.mapper;

import com.expenseTracker.expenseTrackerBackend.dto.UserDetailsDto;
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

    public static UserDetailsDto mapToUserDetails(Users users){
        UserDetailsDto userDetailsDto=UserDetailsDto.builder()
                .totalBalance(users.getTotalBalance())
                .email(users.getEmail())
                .name(users.getName()).build();
        return userDetailsDto;
    }


}

package com.expenseTracker.expenseTrackerBackend.service.impl;

import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.dto.UserDetailsDto;
import com.expenseTracker.expenseTrackerBackend.dto.UserRegistrationDto;
import com.expenseTracker.expenseTrackerBackend.models.Users;
import com.expenseTracker.expenseTrackerBackend.repository.UserRepository;
import com.expenseTracker.expenseTrackerBackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.expenseTracker.expenseTrackerBackend.mapper.UserMapper.mapToUser;
import static com.expenseTracker.expenseTrackerBackend.mapper.UserMapper.mapToUserDetails;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseDto saveUser(UserRegistrationDto userDto) {
        Users users=mapToUser(userDto);
        userRepository.save(users);
        ResponseDto responseDto=new ResponseDto();
        responseDto.setStatus("Saved user successfully!");
        return responseDto;
    }

    @Override
    public Users findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetailsDto getUserById(int id) {
        Users users=userRepository.findById(id);
        UserDetailsDto userDetailsDto=mapToUserDetails(users);
        return userDetailsDto;
    }
}

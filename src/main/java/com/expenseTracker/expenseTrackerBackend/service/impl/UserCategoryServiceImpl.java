package com.expenseTracker.expenseTrackerBackend.service.impl;

import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.models.UserCategory;
import com.expenseTracker.expenseTrackerBackend.models.Users;
import com.expenseTracker.expenseTrackerBackend.repository.UserCategoryRepository;
import com.expenseTracker.expenseTrackerBackend.service.UserCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCategoryServiceImpl implements UserCategoryService {

    private final UserCategoryRepository userCategoryRepository;

    @Override
    public ResponseDto saveUserCategory(UserCategory userCategory) {
        userCategoryRepository.save(userCategory);
        ResponseDto responseDto=new ResponseDto();
        responseDto.setStatus("Saved entry"+userCategory.getCategoryName());
        return responseDto;
    }

    @Override
    public List<UserCategory> getUserCategoryForUser(Users users) {
        return userCategoryRepository.findUserCategoriesByUsers(users);
    }
}

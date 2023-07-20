package com.expenseTracker.expenseTrackerBackend.service;

import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.models.UserCategory;
import com.expenseTracker.expenseTrackerBackend.models.Users;

import java.util.List;

public interface UserCategoryService {
    ResponseDto saveUserCategory(UserCategory userCategory);
    List<UserCategory> getUserCategoryForUser(Users users);
}

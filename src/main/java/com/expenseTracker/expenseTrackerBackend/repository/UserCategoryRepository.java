package com.expenseTracker.expenseTrackerBackend.repository;

import com.expenseTracker.expenseTrackerBackend.models.UserCategory;
import com.expenseTracker.expenseTrackerBackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCategoryRepository extends JpaRepository<UserCategory,Integer> {
    UserCategory findById(int id);
    List<UserCategory> findUserCategoriesByUsers(Users users);
}

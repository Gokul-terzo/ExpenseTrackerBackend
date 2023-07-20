package com.expenseTracker.expenseTrackerBackend.repository;

import com.expenseTracker.expenseTrackerBackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findById(int id);
}

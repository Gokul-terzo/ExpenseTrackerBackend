package com.expenseTracker.expenseTrackerBackend.repository;

import com.expenseTracker.expenseTrackerBackend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

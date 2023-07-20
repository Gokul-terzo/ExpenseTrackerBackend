package com.expenseTracker.expenseTrackerBackend.repository;

import com.expenseTracker.expenseTrackerBackend.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
}

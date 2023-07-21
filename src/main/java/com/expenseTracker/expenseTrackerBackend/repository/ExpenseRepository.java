package com.expenseTracker.expenseTrackerBackend.repository;

import com.expenseTracker.expenseTrackerBackend.models.Expenses;
import com.expenseTracker.expenseTrackerBackend.models.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expenses,Integer> {

    @Query("SELECT e FROM Expenses e WHERE MONTH(e.expenseTime) = MONTH(:date) AND YEAR(e.expenseTime)=YEAR(:date)")
    List<Expenses> getCurrentMonthExpenses(LocalDateTime date);

    List<Expenses> getExpensesByUserCategory(UserCategory userCategory);
}

package com.expenseTracker.expenseTrackerBackend.service;

import com.expenseTracker.expenseTrackerBackend.dto.ExpensesDto;
import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.models.Expenses;

import java.util.Date;
import java.util.List;

public interface ExpenseService {
    ResponseDto saveExpense(ExpensesDto expensesDto);

    List<ExpensesDto> currentMonthExpenses(int userId);
}

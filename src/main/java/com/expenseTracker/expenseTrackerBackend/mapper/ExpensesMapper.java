package com.expenseTracker.expenseTrackerBackend.mapper;

import com.expenseTracker.expenseTrackerBackend.dto.ExpensesDto;
import com.expenseTracker.expenseTrackerBackend.models.Expenses;

public class ExpensesMapper {
    public static Expenses mapToExpenses(ExpensesDto expensesDto){
        Expenses expenses=Expenses.builder()
                .expenseTime(expensesDto.getExpenseTime())
                .amount(expensesDto.getAmount())
                .build();
        return expenses;
    }

    public static ExpensesDto mapToExpensesDto(Expenses expenses){
        ExpensesDto expensesDto=ExpensesDto.builder()
                .userCategoryId(expenses.getUserCategory().getId())
                .userId(expenses.getUsers().getId())
                .expenseTime(expenses.getExpenseTime())
                .amount(expenses.getAmount()).build();
        return expensesDto;
    }

}

package com.expenseTracker.expenseTrackerBackend.service;

import com.expenseTracker.expenseTrackerBackend.dto.IncomeDto;
import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;

public interface IncomeService {
    ResponseDto saveIncome(IncomeDto incomeDto);
}

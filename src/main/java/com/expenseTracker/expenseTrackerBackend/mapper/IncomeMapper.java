package com.expenseTracker.expenseTrackerBackend.mapper;

import com.expenseTracker.expenseTrackerBackend.dto.IncomeDto;
import com.expenseTracker.expenseTrackerBackend.models.Income;

public class IncomeMapper {
    public static Income mapToIncome(IncomeDto incomeDto){
        Income income=Income.builder()
                .amount(incomeDto.getAmount())
                .dateTime(incomeDto.getDateTime())
                .source(incomeDto.getSource()).build();
        return income;
    }
}

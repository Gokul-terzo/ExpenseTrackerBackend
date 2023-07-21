package com.expenseTracker.expenseTrackerBackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBalanceDto {
    private long thresholdAmount;
    private int userCategoryId;
    private long balance;
}

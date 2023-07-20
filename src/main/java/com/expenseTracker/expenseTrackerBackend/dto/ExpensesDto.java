package com.expenseTracker.expenseTrackerBackend.dto;

import com.expenseTracker.expenseTrackerBackend.models.UserCategory;
import com.expenseTracker.expenseTrackerBackend.models.Users;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpensesDto {
    private LocalDateTime expenseTime;
    private long amount;
    private int userCategoryId;
    private int userId;
}

package com.expenseTracker.expenseTrackerBackend.dto;

import com.expenseTracker.expenseTrackerBackend.models.Users;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {
    private LocalDateTime dateTime;
    private long amount;
    private String source;
    private int userId;
}

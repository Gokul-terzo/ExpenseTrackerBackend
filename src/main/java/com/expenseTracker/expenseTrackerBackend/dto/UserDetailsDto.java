package com.expenseTracker.expenseTrackerBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private String name;
    private String email;
    private long totalBalance;
}

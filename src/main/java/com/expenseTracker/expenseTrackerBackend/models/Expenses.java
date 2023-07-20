package com.expenseTracker.expenseTrackerBackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime expenseTime;
    private long amount;
    @ManyToOne
    @JsonBackReference(value = "user-category")
    private UserCategory userCategory;
    @ManyToOne
    @JsonBackReference(value = "user-expense")
    private Users users;
}

package com.expenseTracker.expenseTrackerBackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private long totalBalance;
    @OneToMany(mappedBy = "users")
    @JsonManagedReference(value = "income")
    private List<Income> incomes;
    @OneToMany(mappedBy = "users")
    @JsonManagedReference(value = "user-categories")
    private List<UserCategory> userCategories;
    @OneToMany(mappedBy = "users")
    @JsonManagedReference(value = "user-expense")
    private List<Expenses> expenses;
}

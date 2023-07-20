package com.expenseTracker.expenseTrackerBackend.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate quotaDate;
    private long quotaThreshold;
    private String categoryName;
    @ManyToOne
    @JsonBackReference(value = "user-categories")
    private Users users;
    @OneToMany(mappedBy = "userCategory")
    @JsonManagedReference(value = "user-category")
    List<Expenses> expenses;
}

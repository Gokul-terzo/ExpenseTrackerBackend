package com.expenseTracker.expenseTrackerBackend.service;

import com.expenseTracker.expenseTrackerBackend.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
}

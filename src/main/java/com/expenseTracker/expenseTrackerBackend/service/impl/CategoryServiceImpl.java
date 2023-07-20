package com.expenseTracker.expenseTrackerBackend.service.impl;

import com.expenseTracker.expenseTrackerBackend.models.Category;
import com.expenseTracker.expenseTrackerBackend.repository.CategoryRepository;
import com.expenseTracker.expenseTrackerBackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}

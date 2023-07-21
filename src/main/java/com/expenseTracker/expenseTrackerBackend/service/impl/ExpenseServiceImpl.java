package com.expenseTracker.expenseTrackerBackend.service.impl;

import com.expenseTracker.expenseTrackerBackend.dto.ExpensesDto;
import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.models.Expenses;
import com.expenseTracker.expenseTrackerBackend.models.UserCategory;
import com.expenseTracker.expenseTrackerBackend.models.Users;
import com.expenseTracker.expenseTrackerBackend.repository.ExpenseRepository;
import com.expenseTracker.expenseTrackerBackend.repository.UserCategoryRepository;
import com.expenseTracker.expenseTrackerBackend.repository.UserRepository;
import com.expenseTracker.expenseTrackerBackend.service.ExpenseService;
import com.expenseTracker.expenseTrackerBackend.service.UserCategoryService;
import com.expenseTracker.expenseTrackerBackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.expenseTracker.expenseTrackerBackend.mapper.ExpensesMapper.mapToExpenses;
import static com.expenseTracker.expenseTrackerBackend.mapper.ExpensesMapper.mapToExpensesDto;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final UserCategoryRepository userCategoryRepository;
    @Override
    public ResponseDto saveExpense(ExpensesDto expensesDto) {
        Users users=userRepository.findById(expensesDto.getUserId());
        long amount=expensesDto.getAmount();
        UserCategory userCategory=userCategoryRepository.findById(expensesDto.getUserCategoryId());
        ResponseDto responseDto=new ResponseDto();
        Expenses expenses=mapToExpenses(expensesDto);
        expenses.setUserCategory(userCategory);
        expenses.setUsers(users);
        Expenses expenses1=expenseRepository.save(expenses);
    if(expenses1==null)
        responseDto.setStatus("Failed to save expense");
    else {
        responseDto.setStatus("Saved expense");
        users.setTotalBalance(users.getTotalBalance()-amount);
        Users users1=userRepository.save(users);
        if(users1!=null)
            responseDto.setStatus("Saved expense and updated balance");
    }
    return responseDto;
    }

    @Override
    public List<ExpensesDto> currentMonthExpenses(int userId) {
        List<Expenses> expenses= expenseRepository.getCurrentMonthExpenses(LocalDateTime.now());
        Users users=userRepository.findById(userId);
        List<Expenses> expensesList= expenses.stream().filter(e->e.getUsers().equals(users)).collect(Collectors.toList());
        List<ExpensesDto> expensesDtos=expensesList.stream().map(e->mapToExpensesDto(e)).collect(Collectors.toList());
        return expensesDtos;
    }

    @Override
    public List<ExpensesDto> userCategoryExpenses(int userCategoryId) {
        UserCategory userCategory=userCategoryRepository.findById(userCategoryId);
        List<Expenses> expenses=expenseRepository.getExpensesByUserCategory(userCategory);
        List<ExpensesDto> expensesDtos=expenses.stream().map(e->mapToExpensesDto(e)).collect(Collectors.toList());
        return expensesDtos;
    }

    @Override
    public List<ExpensesDto> customMonthExpenses(LocalDateTime date,int userId) {
        List<Expenses> expenses= expenseRepository.getCurrentMonthExpenses(date);
        Users users=userRepository.findById(userId);
        List<Expenses> expensesList= expenses.stream().filter(e->e.getUsers().equals(users)).collect(Collectors.toList());
        List<ExpensesDto> expensesDtos=expensesList.stream().map(e->mapToExpensesDto(e)).collect(Collectors.toList());
        return expensesDtos;
    }

}

package com.expenseTracker.expenseTrackerBackend.controller;

import com.expenseTracker.expenseTrackerBackend.dto.ExpensesDto;
import com.expenseTracker.expenseTrackerBackend.dto.IncomeDto;
import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.models.*;
import com.expenseTracker.expenseTrackerBackend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExpenseTrackerController {

    private final CategoryService categoryService;
    private final UserService userService;
    private final UserCategoryService userCategoryService;
    private final ExpenseService expenseService;
    private final IncomeService incomeService;

    @GetMapping("/list-categories")
    public List<Category> getCategories(){
    return categoryService.getAll();
    }

    @PostMapping("new-user-categories/{userId}")
    public ResponseDto[] saveUserCategories(@RequestBody List<UserCategory> userCategories,@PathVariable int userId)
    {
        Users users=userService.findById(userId);
        final ResponseDto[] responseDto = {new ResponseDto()};
        userCategories.forEach(e->{
            e.setUsers(users);
            responseDto[0] =userCategoryService.saveUserCategory(e);
        });
        return responseDto;
    }

    @GetMapping("user-categories-list/{userId}")
    public List<UserCategory> getUserCategories(@PathVariable int userId){
        Users users=userService.findById(userId);
        return userCategoryService.getUserCategoryForUser(users);
    }

    @PostMapping("save-expense")
    public ResponseDto saveExpense(@RequestBody ExpensesDto expensesDto){
        return expenseService.saveExpense(expensesDto);
    }

    @PostMapping("save-income")
    public ResponseDto saveIncome(@RequestBody IncomeDto incomeDto){
        return incomeService.saveIncome(incomeDto);
    }

    @GetMapping("current-month-expenses/{userId}")
    public List<ExpensesDto> currentMonthExpenses(@PathVariable int userId)
    {
       return expenseService.currentMonthExpenses(userId);
    }
}

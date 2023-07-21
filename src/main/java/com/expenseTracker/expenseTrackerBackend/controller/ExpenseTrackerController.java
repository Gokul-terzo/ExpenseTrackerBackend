package com.expenseTracker.expenseTrackerBackend.controller;

import com.expenseTracker.expenseTrackerBackend.dto.*;
import com.expenseTracker.expenseTrackerBackend.models.*;
import com.expenseTracker.expenseTrackerBackend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @GetMapping("view-user/{userId}")
    public UserDetailsDto getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @PostMapping("save-expense")
    public ResponseDto saveExpense(@RequestBody ExpensesDto expensesDto){
        return expenseService.saveExpense(expensesDto);
    }

    @PostMapping("save-income")
    public ResponseDto saveIncome(@RequestBody IncomeDto incomeDto){
        return incomeService.saveIncome(incomeDto);
    }

    @GetMapping("current-month-expense-list/{userId}")
    public List<ExpensesDto> currentMonthExpenses(@PathVariable int userId)
    {
       return expenseService.currentMonthExpenses(userId);
    }

    @GetMapping("custom-month-expense-list/{userId}/{date}")
    public List<ExpensesDto> customMonthExpenses(@PathVariable int userId, @PathVariable LocalDateTime date)
    {
        return expenseService.customMonthExpenses(date,userId);
    }
    @GetMapping("category-wise-expenses/{userCategoryId}")
    public List<ExpensesDto> userCategoryWiseExpenses(@PathVariable int userCategoryId)
    {
        return expenseService.userCategoryExpenses(userCategoryId);
    }

    @GetMapping("category-wise-balance/{userId}")
    public List<CategoryBalanceDto> categoryWiseBalance(@PathVariable int userId){
        Users users=userService.findById(userId);
        List<CategoryBalanceDto> categoryBalanceDto=new ArrayList<>();
        List<UserCategory> userCategories= userCategoryService.getUserCategoryForUser(users);
        List<ExpensesDto> expensesDto=new ArrayList<>();
        for(UserCategory userCategory:userCategories){
            expensesDto=expenseService.userCategoryExpenses(userCategory.getId());
            long sum=expensesDto.stream().mapToLong(e->e.getAmount()).sum();
            categoryBalanceDto.add(new CategoryBalanceDto( userCategory.getQuotaThreshold(),userCategory.getId(), userCategory.getQuotaThreshold()-sum));
        }
        return categoryBalanceDto;
    }

    @GetMapping("current-month-total-expense/{userId}")
    public ExpensesDto currentMonthTotalExpenses(@PathVariable int userId)
    {
        ExpensesDto expensesDto=new ExpensesDto();
        List<ExpensesDto> expensesDtoList= expenseService.currentMonthExpenses(userId);
        long sum=expensesDtoList.stream().mapToLong(e->e.getAmount()).sum();
        expensesDto.setAmount(sum);
        return expensesDto;
    }

    @GetMapping("prev-months-total-expense/{date}/{userId}")
    public ExpensesDto prevMonthsTotalExpenses(@PathVariable LocalDateTime date, @PathVariable int userId)
    {
        ExpensesDto expensesDto=new ExpensesDto();
        List<ExpensesDto> expensesDtoList= expenseService.customMonthExpenses(date,userId);
        long sum=expensesDtoList.stream().mapToLong(e->e.getAmount()).sum();
        expensesDto.setAmount(sum);
        return expensesDto;
    }

}
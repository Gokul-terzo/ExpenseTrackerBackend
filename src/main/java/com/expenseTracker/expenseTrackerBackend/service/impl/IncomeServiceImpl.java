package com.expenseTracker.expenseTrackerBackend.service.impl;

import com.expenseTracker.expenseTrackerBackend.dto.IncomeDto;
import com.expenseTracker.expenseTrackerBackend.dto.ResponseDto;
import com.expenseTracker.expenseTrackerBackend.models.Income;
import com.expenseTracker.expenseTrackerBackend.models.Users;
import com.expenseTracker.expenseTrackerBackend.repository.IncomeRepository;
import com.expenseTracker.expenseTrackerBackend.repository.UserRepository;
import com.expenseTracker.expenseTrackerBackend.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.expenseTracker.expenseTrackerBackend.mapper.IncomeMapper.mapToIncome;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;
    @Override
    public ResponseDto saveIncome(IncomeDto incomeDto) {
        ResponseDto responseDto=new ResponseDto();
        Users users=userRepository.findById(incomeDto.getUserId());
        Income income=mapToIncome(incomeDto);
        income.setUsers(users);
        Income income1=incomeRepository.save(income);
        if(income1==null)
            responseDto.setStatus("Couldn't save income");
        else {
            responseDto.setStatus("Saved income");
            users.setTotalBalance(users.getTotalBalance()+incomeDto.getAmount());
            Users users1= userRepository.save(users);
            if(users1!=null)
                responseDto.setStatus("Saved income and updated balance");
        }
        return responseDto;
    }
}

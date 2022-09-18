package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.Expense;
import com.reihaneh.personalexpenses.repository.ExpenseRepository;
import com.reihaneh.personalexpenses.security.SecurityUtils;
import com.reihaneh.personalexpenses.service.ExpenseService;
import com.reihaneh.personalexpenses.service.dto.ExpenseDto;
import com.reihaneh.personalexpenses.service.dto.UserExpensesDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class ExpenseServiceImpl extends BaseServiceImpl<Expense, ExpenseDto, ExpenseRepository, Long> implements ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        super(repository, Expense.class, ExpenseDto.class, log);
        this.repository = repository;
    }

    @Override
    public List<UserExpensesDto> getCurrentUserExpenses() {
        Optional<String> currentUser = SecurityUtils.getCurrentUserLogin();
        if (currentUser.isEmpty())
            throw new UsernameNotFoundException("User is not authenticated.");

        log.info("Get Expenses for user : {}", currentUser.get());

        return repository.getCurrentUserExpenses(currentUser.get());
    }

    @Override
    public List<Map<String, Object>> getCurrentUserMonthlyExpenses() {
        Optional<String> currentUser = SecurityUtils.getCurrentUserLogin();
        if (currentUser.isEmpty())
            throw new UsernameNotFoundException("User is not authenticated.");

        log.info("Get Monthly Expenses for user : {}", currentUser.get());

        return repository.getCurrentUserMonthlyTotalExpenses(currentUser.get());
    }
}

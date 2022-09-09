package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.Expense;
import com.reihaneh.personalexpenses.repository.ExpenseRepository;
import com.reihaneh.personalexpenses.service.ExpenseService;
import com.reihaneh.personalexpenses.service.dto.ExpenseDto;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl extends BaseServiceImpl<Expense, ExpenseDto, ExpenseRepository, Long> implements ExpenseService {

    public ExpenseServiceImpl(ExpenseRepository repository) {
        super(repository, Expense.class, ExpenseDto.class);
    }
}

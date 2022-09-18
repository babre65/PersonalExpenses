package com.reihaneh.personalexpenses.service;

import com.reihaneh.personalexpenses.service.dto.ExpenseDto;
import com.reihaneh.personalexpenses.service.dto.UserExpensesDto;

import java.util.List;
import java.util.Map;

public interface ExpenseService extends BaseService<ExpenseDto, Long> {

    List<UserExpensesDto> getCurrentUserExpenses();

    List<Map<String, Object>> getCurrentUserMonthlyExpenses();
}

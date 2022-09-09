package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.domain.Expense;
import com.reihaneh.personalexpenses.service.ExpenseService;
import com.reihaneh.personalexpenses.service.dto.ExpenseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseResource extends BaseResource<ExpenseDto, ExpenseService, Long> {

    public ExpenseResource(ExpenseService service) {
        super(service);
    }
}

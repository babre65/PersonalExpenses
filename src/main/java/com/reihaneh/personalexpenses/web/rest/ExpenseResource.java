package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.service.ExpenseService;
import com.reihaneh.personalexpenses.service.dto.ExpenseDto;
import com.reihaneh.personalexpenses.service.dto.UserExpensesDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
@Slf4j
@Tag(name = "Expenses")
public class ExpenseResource extends BaseResource<ExpenseDto, ExpenseService, Long> {

    private final ExpenseService service;

    public ExpenseResource(ExpenseService service) {
        super(service, log);
        this.service = service;
    }

    @GetMapping("/user-expenses")
    public ResponseEntity<List<UserExpensesDto>> getCurrentUserExpenses(){
        log.info("Request to get user Expenses");

        List<UserExpensesDto> currentUserExpenses = service.getCurrentUserExpenses();

        return ResponseEntity.ok().body(currentUserExpenses);
    }

    @GetMapping("/monthly-expenses")
    public ResponseEntity<List<Map<String, Object>>> getCurrentUserMonthlyExpenses(){
        log.info("Request to get user Expenses");

        List<Map<String, Object>> monthlyExpenses = service.getCurrentUserMonthlyExpenses();

        return ResponseEntity.ok().body(monthlyExpenses);
    }
}

package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.service.ExpenseService;
import com.reihaneh.personalexpenses.service.dto.ExpenseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
@Slf4j
@Tag(name = "Expenses")
public class ExpenseResource extends BaseResource<ExpenseDto, ExpenseService, Long> {

    public ExpenseResource(ExpenseService service) {
        super(service, log);
    }
}

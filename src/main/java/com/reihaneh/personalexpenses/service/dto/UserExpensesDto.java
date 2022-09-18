package com.reihaneh.personalexpenses.service.dto;

import com.reihaneh.personalexpenses.domain.enums.ExpenseType;
import com.reihaneh.personalexpenses.domain.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserExpensesDto {

    private ExpenseType type;

    private LocalDateTime purchaseDate;

    private PaymentType paymentType;

    private BigDecimal amount;

    private String note;

    private String description;


    private String categoryName;
}

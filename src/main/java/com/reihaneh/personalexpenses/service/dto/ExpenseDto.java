package com.reihaneh.personalexpenses.service.dto;

import com.reihaneh.personalexpenses.domain.enums.ExpenseType;
import com.reihaneh.personalexpenses.domain.enums.PaymentType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ExpenseDto extends BaseDto {

    private ExpenseType type;


    private LocalDateTime purchaseDate;


    private PaymentType paymentType;


    private BigDecimal amount;


    private String note;


    private String description;


    private Long userId;


    private Long categoryId;
}

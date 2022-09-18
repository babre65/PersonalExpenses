package com.reihaneh.personalexpenses.service.dto;

import com.reihaneh.personalexpenses.domain.enums.ExpenseType;
import com.reihaneh.personalexpenses.domain.enums.PaymentType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ExpenseDto extends BaseDto {

    @NotBlank
    private ExpenseType type;

    @NotBlank
    private LocalDateTime purchaseDate;

    @NotBlank
    private PaymentType paymentType;

    @NotBlank
    private BigDecimal amount;

    private String note;

    private String description;

    private Long userId;

    private Long categoryId;
}

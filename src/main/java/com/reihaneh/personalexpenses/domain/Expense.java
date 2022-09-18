package com.reihaneh.personalexpenses.domain;

import com.reihaneh.personalexpenses.domain.enums.ExpenseType;
import com.reihaneh.personalexpenses.domain.enums.PaymentType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Expense extends BaseEntity {

    @NotBlank
    @Column
    @Enumerated(EnumType.STRING)
    private ExpenseType type;

    @NotBlank
    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @NotBlank
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @NotBlank
    @Column
    private BigDecimal amount;

    @Column
    private String note;

    @Column
    private String description;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Category category;

}

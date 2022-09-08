package com.reihaneh.personalexpenses.domain;

import com.reihaneh.personalexpenses.domain.enums.ExpenseType;
import com.reihaneh.personalexpenses.domain.enums.PaymentType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Expense extends BaseEntity {

    @Column
    private ExpenseType type;

    @Column
    private LocalDateTime purchaseDate;

    @Column
    private PaymentType paymentType;

    @Column
    private BigDecimal amount;

    @Column
    private String note;

    @Column
    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

}

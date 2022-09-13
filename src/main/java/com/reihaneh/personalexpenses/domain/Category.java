package com.reihaneh.personalexpenses.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Category extends BaseEntity {

    @NotBlank
    @Column
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Expense> expenses = new ArrayList<>();

}

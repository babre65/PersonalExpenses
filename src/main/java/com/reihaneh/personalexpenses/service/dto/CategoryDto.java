package com.reihaneh.personalexpenses.service.dto;

import com.reihaneh.personalexpenses.domain.Expense;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryDto extends BaseDto {

    private String name;

    private List<Expense> expenses = new ArrayList<>();
}

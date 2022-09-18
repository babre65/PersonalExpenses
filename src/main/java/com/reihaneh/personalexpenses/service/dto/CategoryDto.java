package com.reihaneh.personalexpenses.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CategoryDto extends BaseDto {

    @NotBlank
    private String name;

    private List<ExpenseDto> expenses = new ArrayList<>();
}

package com.reihaneh.personalexpenses.service.dto;

import com.reihaneh.personalexpenses.domain.Expense;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends BaseDto {

    private String firstName;

    private String lastName;

    private ZonedDateTime birthDate;

    private String email;

    private String phoneNo;

    private String avatar;

    private Boolean active;

    private String username;

    private String password;

    private List<Expense> expenses = new ArrayList<>();
}

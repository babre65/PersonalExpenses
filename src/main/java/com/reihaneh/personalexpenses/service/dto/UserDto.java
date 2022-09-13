package com.reihaneh.personalexpenses.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends BaseDto {

    @NotBlank
    private String firstName;

    private String lastName;

    private ZonedDateTime birthDate;

    @Email
    @NotEmpty
    private String email;

    private String phoneNo;

    private String avatar;

    private Boolean active = Boolean.TRUE;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private List<ExpenseDto> expenses = new ArrayList<>();
}

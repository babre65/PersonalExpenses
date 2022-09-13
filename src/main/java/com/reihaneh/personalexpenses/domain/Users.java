package com.reihaneh.personalexpenses.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Users extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private ZonedDateTime birthDate;

    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;

    @Column
    private String phoneNo;

    @Column
    private String avatar;

    @Column
    private Boolean active;

    @NotBlank
    @Column
    private String username;

    @NotBlank
    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Expense> expenses = new ArrayList<>();
}

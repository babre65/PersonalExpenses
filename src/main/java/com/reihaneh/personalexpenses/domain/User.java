package com.reihaneh.personalexpenses.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity{

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private ZonedDateTime birthDate;

    @Column
    private String email;

    @Column
    private String phoneNo;

    @Column
    private String avatar;

    @Column
    private Boolean active;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Expense> expenses = new ArrayList<>();
}

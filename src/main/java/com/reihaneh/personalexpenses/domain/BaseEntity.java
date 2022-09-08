package com.reihaneh.personalexpenses.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column
//    @CreatedBy
//    private String createdBy;
//
//    @Column
//    @CreatedDate
//    private LocalDateTime createdDate;
//
//    @Column
//    @LastModifiedBy
//    private String modifiedBy;
//
//    @Column
//    @LastModifiedDate
//    private LocalDateTime modifiedDate;

}

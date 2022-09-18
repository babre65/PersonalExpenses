package com.reihaneh.personalexpenses.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public abstract class BaseDto {

    private Long id;

//    private String createdBy;
//
//    private LocalDateTime createdDate;
//
//    private String modifiedBy;
//
//    private LocalDateTime modifiedDate;


    @Override
    public String toString() {
        return "> id=" + id;
    }
}

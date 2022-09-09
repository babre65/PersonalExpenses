package com.reihaneh.personalexpenses.service;

import com.reihaneh.personalexpenses.domain.BaseEntity;
import com.reihaneh.personalexpenses.service.dto.BaseDto;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseDto, ID> {

    T save (T t);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id);
}

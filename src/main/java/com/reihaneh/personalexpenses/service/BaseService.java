package com.reihaneh.personalexpenses.service;

import com.reihaneh.personalexpenses.service.dto.BaseDto;

import java.util.List;
import java.util.Optional;

public interface BaseService<D extends BaseDto, ID> {

    D save (D dto);

    Optional<D> findById(ID id);

    List<D> findAll();

    void deleteById(ID id);
}

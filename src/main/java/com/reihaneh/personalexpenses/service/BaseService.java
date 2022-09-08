package com.reihaneh.personalexpenses.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {

    T save (T t);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id);
}

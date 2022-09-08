package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.BaseEntity;
import com.reihaneh.personalexpenses.repository.BaseRepository;
import com.reihaneh.personalexpenses.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseServiceImpl<T extends BaseEntity, R extends BaseRepository<T, ID>, ID> implements BaseService<T, ID> {

    private final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}

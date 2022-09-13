package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.BaseEntity;
import com.reihaneh.personalexpenses.repository.BaseRepository;
import com.reihaneh.personalexpenses.service.BaseService;
import com.reihaneh.personalexpenses.service.dto.BaseDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class BaseServiceImpl<T extends BaseEntity, D extends BaseDto, R extends BaseRepository<T, ID>, ID> implements BaseService<D, ID> {

    @Autowired
    protected ModelMapper mapper;
    private final R repository;

    private final Class<T> entityClass;

    private final Class<D> dtoClass;

    private final Logger log;

    public BaseServiceImpl(R repository, Class<T> entityClass, Class<D> dtoClass, Logger log) {
        this.repository = repository;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.log = log;
    }

    @Override
    public D save(D dto) {
        log.info("Request to save dto object: {}", dto);

        T entity = mapper.map(dto, entityClass);
        dto = mapper.map(repository.save(entity), dtoClass);

        log.info("Saved Dto : {}", dto);
        return dto;
    }

    @Override
    public Optional<D> findById(ID id) {
        log.info("Request to find an object by Id: {}", id);

        Optional<T> result = repository.findById(id);
        return result.map(t -> mapper.map(t, dtoClass));
    }

    @Override
    public List<D> findAll() {
        log.info("Request to find all data.");

        List<T> all = repository.findAll();
        return all.stream().map(t -> mapper.map(t, dtoClass)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(ID id) {
        log.info("Request to delete an object by Id: {}", id);

        repository.deleteById(id);
    }
}

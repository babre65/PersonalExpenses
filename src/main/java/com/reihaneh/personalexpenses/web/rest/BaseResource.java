package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.domain.BaseEntity;
import com.reihaneh.personalexpenses.service.BaseService;
import com.reihaneh.personalexpenses.service.dto.BaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseResource<T extends BaseDto, S extends BaseService<T, ID>, ID> {

    private final S service;

    public BaseResource(S service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        if (entity.getId() != null)
            return ResponseEntity.badRequest().build();

        T save = service.save(entity);
        return ResponseEntity.ok().body(save);
    }


    @PutMapping
    public ResponseEntity<T> update(@RequestBody T entity) {
        if (entity.getId() == null)
            return ResponseEntity.badRequest().build();

        T save = service.save(entity);
        return ResponseEntity.ok().body(save);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {

        Optional<T> result = service.findById(id);
        return result.map(t -> ResponseEntity.ok().body(t)).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() {

        List<T> all = service.findAll();
        return ResponseEntity.ok().body(all);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

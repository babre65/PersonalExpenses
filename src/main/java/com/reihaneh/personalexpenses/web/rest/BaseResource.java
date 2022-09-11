package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.service.BaseService;
import com.reihaneh.personalexpenses.service.dto.BaseDto;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseResource<T extends BaseDto, S extends BaseService<T, ID>, ID> {

    private final S service;
    private final Logger log;

    public BaseResource(S service, Logger log) {
        this.service = service;
        this.log = log;
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T dto) {
        log.info("Request to create object: {}", dto);
        if (dto.getId() != null)
            return ResponseEntity.badRequest().build();

        T save = service.save(dto);
        log.info("Data saved : {}", save);
        return ResponseEntity.ok().body(save);
    }


    @PutMapping
    public ResponseEntity<T> update(@RequestBody T dto) {
        log.info("Request to update object: {}", dto);
        if (dto.getId() == null)
            return ResponseEntity.badRequest().build();

        T save = service.save(dto);
        log.info("Data saved : {}", save);
        return ResponseEntity.ok().body(save);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        log.info("Request to get an object by Id : {}", id);

        Optional<T> result = service.findById(id);
        return result.map(t -> ResponseEntity.ok().body(t)).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        log.info("Request to get all data. ");

        List<T> all = service.findAll();
        return ResponseEntity.ok().body(all);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        log.info("Request to delete object by Id : {}", id);

        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

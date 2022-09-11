package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.service.BaseService;
import com.reihaneh.personalexpenses.service.dto.BaseDto;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public abstract class BaseResource<D extends BaseDto, S extends BaseService<D, ID>, ID> {

    private final S service;
    private final Logger log;

    public BaseResource(S service, Logger log) {
        this.service = service;
        this.log = log;
    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {
        log.info("Request to create object: {}", dto);
        if (dto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id should be null");

        D save = service.save(dto);
        log.info("Data saved : {}", save);
        return ResponseEntity.ok().body(save);
    }


    @PutMapping
    public ResponseEntity<D> update(@RequestBody D dto) {
        log.info("Request to update object: {}", dto);
        if (dto.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id shouldn't be null");

        D save = service.save(dto);
        log.info("Data saved : {}", save);
        return ResponseEntity.ok().body(save);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<D> findById(@PathVariable ID id) {
        log.info("Request to get an object by Id : {}", id);
        if (id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id should not be null");

        Optional<D> result = service.findById(id);
        return result.map(t -> ResponseEntity.ok().body(t)).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Value not found for Id: " + id));

    }

    @GetMapping
    public ResponseEntity<List<D>> findAll() {
        log.info("Request to get all data. ");

        List<D> all = service.findAll();
        return ResponseEntity.ok().body(all);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        log.info("Request to delete object by Id : {}", id);
        if (id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id should not be null");

        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

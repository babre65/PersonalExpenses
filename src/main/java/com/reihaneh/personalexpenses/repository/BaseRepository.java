package com.reihaneh.personalexpenses.repository;

import com.reihaneh.personalexpenses.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {
}

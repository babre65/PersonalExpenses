package com.reihaneh.personalexpenses.repository;

import com.reihaneh.personalexpenses.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
}

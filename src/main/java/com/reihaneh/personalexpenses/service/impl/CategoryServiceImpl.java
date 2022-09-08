package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.Category;
import com.reihaneh.personalexpenses.repository.CategoryRepository;
import com.reihaneh.personalexpenses.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryRepository, Long> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}

package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.Category;
import com.reihaneh.personalexpenses.repository.CategoryRepository;
import com.reihaneh.personalexpenses.service.CategoryService;
import com.reihaneh.personalexpenses.service.dto.CategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryDto, CategoryRepository, Long> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository, Category.class, CategoryDto.class, log);
    }
}

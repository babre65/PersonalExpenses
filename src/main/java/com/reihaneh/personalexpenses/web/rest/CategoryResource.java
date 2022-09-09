package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.domain.Category;
import com.reihaneh.personalexpenses.service.CategoryService;
import com.reihaneh.personalexpenses.service.dto.CategoryDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource extends BaseResource<CategoryDto, CategoryService, Long>{

    public CategoryResource(CategoryService service) {
        super(service);
    }
}

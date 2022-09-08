package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.domain.Category;
import com.reihaneh.personalexpenses.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource extends BaseResource<Category, CategoryService, Long>{

    public CategoryResource(CategoryService service) {
        super(service);
    }
}

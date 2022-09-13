package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.service.CategoryService;
import com.reihaneh.personalexpenses.service.dto.CategoryDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@Slf4j
@Tag(name = "Category")
public class CategoryResource extends BaseResource<CategoryDto, CategoryService, Long> {

    public CategoryResource(CategoryService service) {
        super(service, log);
    }
}

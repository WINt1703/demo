package com.example.demo.mappers;

import com.example.demo.dtos.CategoryDto;
import com.example.demo.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);
    CategoryDto fromEntity(Category category);
}

package ru.practicum.mainservicekitt.category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategories(int from, int size);

    CategoryDto getCategoryById(long catId);

    CategoryDto createCategory(NewCategoryDto newCategoryDto);

    CategoryDto updateCategory(long catId, NewCategoryDto newCategoryDto);

    void deleteCategory(long catId);
}

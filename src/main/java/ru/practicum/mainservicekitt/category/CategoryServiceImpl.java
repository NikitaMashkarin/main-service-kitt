package ru.practicum.mainservicekitt.category;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.practicum.mainservicekitt.event.Event;
import ru.practicum.mainservicekitt.event.EventRepository;
import ru.practicum.mainservicekitt.exceptions.CategoryNotFoundException;
import ru.practicum.mainservicekitt.exceptions.ConflictException;
import ru.practicum.mainservicekitt.exceptions.ForbiddenException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final EventRepository eventRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> getCategories(int from, int size) {
        return categoryRepository.findAll(PageRequest.of(from / size, size))
                .stream()
                .map(CategoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDto getCategoryById(long catId) {
        return toCategoryDto(categoryRepository.findById(catId)
                .orElseThrow(() -> new CategoryNotFoundException(catId)));
    }

    @Override
    @Transactional
    public CategoryDto createCategory(NewCategoryDto newCategoryDto) {
        Optional<Category> existingCategory = categoryRepository.findByName(newCategoryDto.getName());
        if (existingCategory.isPresent()) {
            throw new ConflictException("Категория с таким именем уже существует: " + newCategoryDto.getName());
        }

        Category category = toCategory(newCategoryDto);
        return toCategoryDto(categoryRepository.save(category));
    }


    @Override
    @Transactional
    public CategoryDto updateCategory(long catId, NewCategoryDto newCategoryDto) {
        Category existCategory = categoryRepository.findById(catId)
                .orElseThrow(() -> new CategoryNotFoundException(catId));
        Category updatedCategory = toCategory(newCategoryDto);
        updatedCategory.setId(existCategory.getId());
        return toCategoryDto(categoryRepository.save(updatedCategory));
    }

    @Override
    @Transactional
    public void deleteCategory(long catId) {
        categoryRepository.findById(catId)
                .orElseThrow(() -> new CategoryNotFoundException(catId));
        Event event = eventRepository.findFirstByCategoryId(catId);
        if (event != null) {
            throw new ForbiddenException("Категория не пустая");
        }
        categoryRepository.deleteById(catId);
    }
}

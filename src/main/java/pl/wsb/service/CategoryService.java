package pl.wsb.service;

import org.springframework.stereotype.Service;
import pl.wsb.model.Category;
import pl.wsb.error.CategoryNotFoundException;
import pl.wsb.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	public Category findCategoryById(String id) {
		return categoryRepository.findById(Long.parseLong(id))
				.orElseThrow(() -> new CategoryNotFoundException(Long.parseLong(id)));
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category updateCategory(Category newCategory) {
		return categoryRepository.findById(newCategory.getCategoryId())
				.map(category -> {
					category.setCategoryId(newCategory.getCategoryId());
					category.setName(newCategory.getName());
					return categoryRepository.save(category);
				})
				.orElseThrow(() -> new CategoryNotFoundException(newCategory.getCategoryId()));
	}

	public void deleteCategory(String id) {
		categoryRepository.deleteById(Long.parseLong(id));
	}
}

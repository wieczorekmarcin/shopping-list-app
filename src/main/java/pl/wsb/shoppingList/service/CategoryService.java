package pl.wsb.shoppingList.service;

import org.springframework.stereotype.Service;
import pl.wsb.shoppingList.error.CategoryNotFoundException;
import pl.wsb.shoppingList.model.Category;
import pl.wsb.shoppingList.repository.CategoryRepository;

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

	public Category updateCategory(Category newCategory, String id) {
		return categoryRepository.findById(Long.parseLong(id))
				.map(category -> {
					category.setId(newCategory.getId());
					category.setName(newCategory.getName());
					return categoryRepository.save(category);
				})
				.orElseThrow(() -> new CategoryNotFoundException(Long.parseLong(id)));
	}

	public void deleteCategory(String id) {
		categoryRepository.deleteById(Long.parseLong(id));
	}
}

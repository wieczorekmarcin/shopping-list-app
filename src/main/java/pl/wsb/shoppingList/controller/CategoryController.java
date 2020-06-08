package pl.wsb.shoppingList.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.shoppingList.model.Category;
import pl.wsb.shoppingList.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(path = "/categories", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> allCategories = categoryService.findAllCategories();
		return new ResponseEntity(allCategories, HttpStatus.OK);
	}

	@RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategory(@PathVariable("id") String id) {
		Category categoryById = categoryService.findCategoryById(id);
		return new ResponseEntity(categoryById, HttpStatus.OK);
	}

	@RequestMapping(path = "/categories", method = RequestMethod.POST)
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category newCategory = categoryService.createCategory(category);
		return new ResponseEntity(newCategory, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/categories/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("id") String id) {
		Category updatedCategory = categoryService.updateCategory(category, id);
		return new ResponseEntity(updatedCategory, HttpStatus.OK);

	}

	@RequestMapping(path = "/categories/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable("id") String id) {
		categoryService.deleteCategory(id);
	}
}

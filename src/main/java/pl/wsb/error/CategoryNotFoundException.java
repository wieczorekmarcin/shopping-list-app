package pl.wsb.error;

public class CategoryNotFoundException extends RuntimeException {
	public CategoryNotFoundException(Long id) {
		super("Category id not found : " + id);
	}

}
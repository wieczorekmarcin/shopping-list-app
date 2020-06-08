package pl.wsb.shoppingList.service;

import org.springframework.stereotype.Service;
import pl.wsb.shoppingList.error.CategoryNotFoundException;
import pl.wsb.shoppingList.error.ProductNotFoundException;
import pl.wsb.shoppingList.model.Product;
import pl.wsb.shoppingList.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductById(String id) {
		return productRepository.findById(Long.parseLong(id))
				.orElseThrow(() -> new ProductNotFoundException(Long.parseLong(id)));
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product newProduct, String id) {
		return productRepository.findById(Long.parseLong(id))
				.map(product -> {
					product.setId(newProduct.getId());
					product.setName(newProduct.getName());
					product.setDescription(newProduct.getDescription());
					product.setCategory(newProduct.getCategory());
					product.setUnit(newProduct.getUnit());
					return productRepository.save(product);
				})
				.orElseThrow(() -> new ProductNotFoundException(Long.parseLong(id)));
	}

	public void deleteProduct(String id) {
		productRepository.deleteById(Long.parseLong(id));
	}
}

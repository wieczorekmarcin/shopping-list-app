package pl.wsb.shoppingList.controller;

import org.springframework.web.bind.annotation.*;
import pl.wsb.shoppingList.model.Product;
import pl.wsb.shoppingList.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(path = "/products", method = RequestMethod.GET)
	public List<Product> getAllproducts() {
		return productService.findAllProducts();
	}

	@RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") String id) {
		return productService.findProductById(id);
	}

	@RequestMapping(path = "/products", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@RequestMapping(path = "/products/{id}", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product, @PathVariable("id") String id) {
		return productService.updateProduct(product, id);
	}

	@RequestMapping(path = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") String id) {
		productService.deleteProduct(id);
	}
}

package pl.wsb.controller;

import org.springframework.web.bind.annotation.*;
import pl.wsb.model.Product;
import pl.wsb.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(path = "/api/products", method = RequestMethod.GET)
	public List<Product> getAllproducts() {
		return productService.findAllProducts();
	}

	@RequestMapping(path = "/api/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") String id) {
		return productService.findProductById(id);
	}

	@RequestMapping(path = "/api/products", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@RequestMapping(path = "/api/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@RequestMapping(path = "/api/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") String id) {
		productService.deleteProduct(id);
	}
}

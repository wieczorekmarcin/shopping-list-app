package pl.wsb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.wsb.model.Product;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductController productController;

	@Test
	public void getProducts() throws Exception {
		Product product = new Product();
		product.setName("water");

		List<Product> allProducts = singletonList(product);

		given(productController.getAllproducts()).willReturn(allProducts);

		mvc.perform(get("/api/products")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(product.getName())));
	}

	@Test
	public void getProductById() throws Exception {
		Product product = new Product();
		product.setName("vodka");

		given(productController.getProduct(product.getId().toString())).willReturn(product);

		mvc.perform(get("/api/products/" + product.getId())
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("vodka", is(product.getName())));
	}
}

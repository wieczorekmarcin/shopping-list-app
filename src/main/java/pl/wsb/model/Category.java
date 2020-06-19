package pl.wsb.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;

	private String name;

	@OneToMany(targetEntity=Product.class, mappedBy="category",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> products;

	public Category() {
	}

	public Category(Long categoryId, @NotNull String name, @NotNull Set<Product> products) {
		this.categoryId = categoryId;
		this.name = name;
		this.products = products;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
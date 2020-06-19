package pl.wsb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Products")
@JsonIgnoreProperties({"category"})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@ManyToOne()
	@JoinColumn(name="categoryId", referencedColumnName = "categoryId", insertable = false, updatable = false)
	private Category category;

	@ManyToOne
	private Unit unit;

	public Product() {
	}

	public Product(Long id, String name, Category category, Unit unit) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
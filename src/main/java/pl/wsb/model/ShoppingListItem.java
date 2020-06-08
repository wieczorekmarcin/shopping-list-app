package pl.wsb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ShoppingListItems")
public class ShoppingListItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private boolean purchased;

	@NotNull
	@OneToOne
	private Product product;

	@NotNull
	@ManyToOne
	private ShoppingList shoppingList;

	public ShoppingListItem() {
	}

	public ShoppingListItem(Long id, String description, boolean purchased, Product product, ShoppingList shoppingList) {
		this.id = id;
		this.description = description;
		this.purchased = purchased;
		this.product = product;
		this.shoppingList = shoppingList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}
}
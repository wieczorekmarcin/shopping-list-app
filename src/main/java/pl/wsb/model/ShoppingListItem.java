package pl.wsb.model;

import javax.persistence.*;

@Entity
@Table(name = "ShoppingListItems")
public class ShoppingListItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean purchased;

	@OneToOne
	private Product product;

	public ShoppingListItem() {
	}

	public ShoppingListItem(Long id, boolean purchased, Product product) {
		this.id = id;
		this.purchased = purchased;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
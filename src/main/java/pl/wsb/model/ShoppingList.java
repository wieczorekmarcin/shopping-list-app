package pl.wsb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ShoppingLists")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shoppingListId;

	private String name;

	private String description;

	private Date createdOn;

	private boolean completed;

	private boolean favourite;

	private boolean deleted;

	@OneToMany
	private Set<ShoppingListItem> items;

	public ShoppingList() {
	}

	public ShoppingList(Long shoppingListId, String name, String description, Date createdOn, boolean completed, boolean favourite, boolean deleted, Set<ShoppingListItem> items) {
		this.shoppingListId = shoppingListId;
		this.name = name;
		this.description = description;
		this.createdOn = createdOn;
		this.completed = completed;
		this.favourite = favourite;
		this.deleted = deleted;
		this.items = items;
	}

	public Long getShoppingListId() {
		return shoppingListId;
	}

	public void setShoppingListId(Long shoppingListId) {
		this.shoppingListId = shoppingListId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Set<ShoppingListItem> getItems() {
		return items;
	}

	public void setItems(Set<ShoppingListItem> items) {
		this.items = items;
	}
}
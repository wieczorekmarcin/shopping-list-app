package pl.wsb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ShoppingLists")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	private Date createdOn;

	private boolean completed;

	private boolean favourite;

	@OneToMany(mappedBy = "shoppingList")
	private List<ShoppingListItem> items;

	public ShoppingList() {
	}

	public ShoppingList(Long id, String name, Date createdOn, boolean completed, boolean favourite, List<ShoppingListItem> items) {
		this.id = id;
		this.name = name;
		this.createdOn = createdOn;
		this.completed = completed;
		this.favourite = favourite;
		this.items = items;
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

	public List<ShoppingListItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingListItem> items) {
		this.items = items;
	}
}
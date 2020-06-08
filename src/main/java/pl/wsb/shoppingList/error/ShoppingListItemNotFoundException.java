package pl.wsb.shoppingList.error;

public class ShoppingListItemNotFoundException extends RuntimeException {
	public ShoppingListItemNotFoundException(Long id) {
		super("ShoppingListItem id not found : " + id);
	}

}
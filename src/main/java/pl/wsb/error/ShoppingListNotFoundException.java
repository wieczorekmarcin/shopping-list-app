package pl.wsb.error;

public class ShoppingListNotFoundException extends RuntimeException {
	public ShoppingListNotFoundException(Long id) {
		super("ShoppingList id not found : " + id);
	}

}
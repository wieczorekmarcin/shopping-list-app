package pl.wsb.shoppingList.service;

import org.springframework.stereotype.Service;
import pl.wsb.shoppingList.error.ShoppingListItemNotFoundException;
import pl.wsb.shoppingList.model.ShoppingListItem;
import pl.wsb.shoppingList.repository.ShoppingListItemRepository;

import java.util.List;

@Service
public class ShoppingListItemService {

	private final ShoppingListItemRepository shoppingListItemRepository;

	public ShoppingListItemService(ShoppingListItemRepository shoppingListItemRepository) {
		this.shoppingListItemRepository = shoppingListItemRepository;
	}

	public List<ShoppingListItem> findAllShoppingListItems() {
		return shoppingListItemRepository.findAll();
	}

	public ShoppingListItem findShoppingListItemById(String id) {
		return shoppingListItemRepository.findById(Long.parseLong(id))
				.orElseThrow(() -> new ShoppingListItemNotFoundException(Long.parseLong(id)));
	}

	public ShoppingListItem createShoppingListItem(ShoppingListItem shoppingListItem) {
		return shoppingListItemRepository.save(shoppingListItem);
	}

	public ShoppingListItem updateShoppingListItem(ShoppingListItem newShoppingListItem, String id) {
		return shoppingListItemRepository.findById(Long.parseLong(id))
				.map(shoppingListItem -> {
					shoppingListItem.setId(newShoppingListItem.getId());
					shoppingListItem.setDescription(newShoppingListItem.getDescription());
					shoppingListItem.setProduct(newShoppingListItem.getProduct());
					shoppingListItem.setShoppingList(newShoppingListItem.getShoppingList());
					shoppingListItem.setPurchased(newShoppingListItem.isPurchased());
					return shoppingListItemRepository.save(shoppingListItem);
				})
				.orElseThrow(() -> new ShoppingListItemNotFoundException(Long.parseLong(id)));
	}

	public void deleteShoppingListItem(String id) {
		shoppingListItemRepository.deleteById(Long.parseLong(id));
	}
}

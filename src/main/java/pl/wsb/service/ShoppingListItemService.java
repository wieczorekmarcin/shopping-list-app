package pl.wsb.service;

import org.springframework.stereotype.Service;
import pl.wsb.model.ShoppingListItem;
import pl.wsb.error.ShoppingListItemNotFoundException;
import pl.wsb.repository.ShoppingListItemRepository;

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

	public ShoppingListItem updateShoppingListItem(ShoppingListItem newShoppingListItem) {
		return shoppingListItemRepository.findById(newShoppingListItem.getId())
				.map(shoppingListItem -> {
					shoppingListItem.setId(newShoppingListItem.getId());
					shoppingListItem.setProduct(newShoppingListItem.getProduct());
					shoppingListItem.setPurchased(newShoppingListItem.isPurchased());
					return shoppingListItemRepository.save(shoppingListItem);
				})
				.orElseThrow(() -> new ShoppingListItemNotFoundException(newShoppingListItem.getId()));
	}

	public void deleteShoppingListItem(String id) {
		shoppingListItemRepository.deleteById(Long.parseLong(id));
	}
}

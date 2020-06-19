package pl.wsb.service;

import org.springframework.stereotype.Service;
import pl.wsb.model.ShoppingList;
import pl.wsb.error.ShoppingListNotFoundException;
import pl.wsb.repository.ShoppingListRepository;

import java.util.List;

@Service
public class ShoppingListService {

	private final ShoppingListRepository shoppingListRepository;

	public ShoppingListService(ShoppingListRepository shoppingListRepository) {
		this.shoppingListRepository = shoppingListRepository;
	}

	public List<ShoppingList> findAllShoppingLists() {
		return shoppingListRepository.findAll();
	}

	public ShoppingList findShoppingListById(String id) {
		return shoppingListRepository.findById(Long.parseLong(id))
				.orElseThrow(() -> new ShoppingListNotFoundException(Long.parseLong(id)));
	}

	public ShoppingList createShoppingList(ShoppingList shoppingList) {
		return shoppingListRepository.save(shoppingList);
	}

	public ShoppingList updateShoppingList(ShoppingList newShoppingList) {
		return shoppingListRepository.findById(newShoppingList.getShoppingListId())
				.map(shoppingList -> {
					shoppingList.setShoppingListId(newShoppingList.getShoppingListId());
					shoppingList.setName(newShoppingList.getName());
					shoppingList.setCreatedOn(newShoppingList.getCreatedOn());
					shoppingList.setCompleted(newShoppingList.isCompleted());
					shoppingList.setFavourite(newShoppingList.isFavourite());
					shoppingList.setDeleted(newShoppingList.isDeleted());
					shoppingList.setItems(newShoppingList.getItems());
					return shoppingListRepository.save(shoppingList);
				})
				.orElseThrow(() -> new ShoppingListNotFoundException(newShoppingList.getShoppingListId()));
	}

	public void deleteShoppingList(String id) {
		shoppingListRepository.deleteById(Long.parseLong(id));
	}
}

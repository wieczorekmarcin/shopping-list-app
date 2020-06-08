package pl.wsb.shoppingList.controller;

import org.springframework.web.bind.annotation.*;
import pl.wsb.shoppingList.model.ShoppingListItem;
import pl.wsb.shoppingList.service.ShoppingListItemService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ShoppingListItemController {

	private final ShoppingListItemService shoppingListItemService;

	public ShoppingListItemController(ShoppingListItemService shoppingListItemService) {
		this.shoppingListItemService = shoppingListItemService;
	}

	@RequestMapping(path = "/shoppingListItems", method = RequestMethod.GET)
	public List<ShoppingListItem> getAllShoppingListItems() {
		return shoppingListItemService.findAllShoppingListItems();
	}

	@RequestMapping(path = "/shoppingListItems/{id}", method = RequestMethod.GET)
	public ShoppingListItem getShoppingListItem(@PathVariable("id") String id) {
		return shoppingListItemService.findShoppingListItemById(id);
	}

	@RequestMapping(path = "/shoppingListItems", method = RequestMethod.POST)
	public ShoppingListItem createShoppingListItem(@RequestBody ShoppingListItem shoppingListItem) {
		return shoppingListItemService.createShoppingListItem(shoppingListItem);
	}

	@RequestMapping(path = "/shoppingListItems/{id}", method = RequestMethod.PUT)
	public ShoppingListItem updateShoppingListItem(@RequestBody ShoppingListItem shoppingListItem, @PathVariable("id") String id) {
		return shoppingListItemService.updateShoppingListItem(shoppingListItem, id);
	}

	@RequestMapping(path = "/shoppingListItems/{id}", method = RequestMethod.DELETE)
	public void deleteShoppingListItem(@PathVariable("id") String id) {
		shoppingListItemService.deleteShoppingListItem(id);
	}
}

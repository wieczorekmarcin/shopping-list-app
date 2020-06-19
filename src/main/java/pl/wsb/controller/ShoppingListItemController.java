package pl.wsb.controller;

import org.springframework.web.bind.annotation.*;
import pl.wsb.model.ShoppingListItem;
import pl.wsb.service.ShoppingListItemService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ShoppingListItemController {

	private final ShoppingListItemService shoppingListItemService;

	public ShoppingListItemController(ShoppingListItemService shoppingListItemService) {
		this.shoppingListItemService = shoppingListItemService;
	}

	@RequestMapping(path = "/api/shoppingListItems", method = RequestMethod.GET)
	public List<ShoppingListItem> getAllShoppingListItems() {
		return shoppingListItemService.findAllShoppingListItems();
	}

	@RequestMapping(path = "/api/shoppingListItems/{id}", method = RequestMethod.GET)
	public ShoppingListItem getShoppingListItem(@PathVariable("id") String id) {
		return shoppingListItemService.findShoppingListItemById(id);
	}

	@RequestMapping(path = "/api/shoppingListItems", method = RequestMethod.POST)
	public ShoppingListItem createShoppingListItem(@RequestBody ShoppingListItem shoppingListItem) {
		return shoppingListItemService.createShoppingListItem(shoppingListItem);
	}

	@RequestMapping(path = "/api/shoppingListItems", method = RequestMethod.PUT)
	public ShoppingListItem updateShoppingListItem(@RequestBody ShoppingListItem shoppingListItem) {
		return shoppingListItemService.updateShoppingListItem(shoppingListItem);
	}

	@RequestMapping(path = "/api/shoppingListItems/{id}", method = RequestMethod.DELETE)
	public void deleteShoppingListItem(@PathVariable("id") String id) {
		shoppingListItemService.deleteShoppingListItem(id);
	}
}

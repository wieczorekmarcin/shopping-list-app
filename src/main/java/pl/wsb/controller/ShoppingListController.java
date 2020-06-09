package pl.wsb.controller;

import org.springframework.web.bind.annotation.*;
import pl.wsb.model.ShoppingList;
import pl.wsb.service.ShoppingListService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ShoppingListController {

	private final ShoppingListService shoppingListService;

	public ShoppingListController(ShoppingListService shoppingListService) {
		this.shoppingListService = shoppingListService;
	}

	@RequestMapping(path = "/api/shoppingLists", method = RequestMethod.GET)
	public List<ShoppingList> getAllShoppingLists() {
		return shoppingListService.findAllShoppingLists();
	}

	@RequestMapping(path = "/api/shoppingLists/{id}", method = RequestMethod.GET)
	public ShoppingList getShoppingList(@PathVariable("id") String id) {
		return shoppingListService.findShoppingListById(id);
	}

	@RequestMapping(path = "/api/shoppingLists", method = RequestMethod.POST)
	public ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList) {
		return shoppingListService.createShoppingList(shoppingList);
	}

	@RequestMapping(path = "/api/shoppingLists/{id}", method = RequestMethod.PUT)
	public ShoppingList updateShoppingList(@RequestBody ShoppingList shoppingList, @PathVariable("id") String id) {
		return shoppingListService.updateShoppingList(shoppingList, id);
	}

	@RequestMapping(path = "/api/shoppingLists/{id}", method = RequestMethod.DELETE)
	public void deleteShoppingList(@PathVariable("id") String id) {
		shoppingListService.deleteShoppingList(id);
	}
}

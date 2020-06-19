package pl.wsb.controller;

import org.springframework.web.bind.annotation.*;
import pl.wsb.model.Unit;
import pl.wsb.service.UnitService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UnitController {

	private final UnitService unitService;

	public UnitController(UnitService unitService) {
		this.unitService = unitService;
	}

	@RequestMapping(path = "/api/units", method = RequestMethod.GET)
	public List<Unit> getAllunits() {
		return unitService.findAllUnits();
	}

	@RequestMapping(path = "/api/units/{id}", method = RequestMethod.GET)
	public Unit getUnit(@PathVariable("id") String id) {
		return unitService.findUnitById(id);
	}

	@RequestMapping(path = "/api/units", method = RequestMethod.POST)
	public Unit createUnit(@RequestBody Unit unit) {
		return unitService.createUnit(unit);
	}

	@RequestMapping(path = "/api/units", method = RequestMethod.PUT)
	public Unit updateUnit(@RequestBody Unit unit) {
		return unitService.updateUnit(unit);
	}

	@RequestMapping(path = "/api/units/{id}", method = RequestMethod.DELETE)
	public void deleteUnit(@PathVariable("id") String id) {
		unitService.deleteUnit(id);
	}
}

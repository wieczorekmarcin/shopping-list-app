package pl.wsb.shoppingList.service;

import org.springframework.stereotype.Service;
import pl.wsb.shoppingList.error.ShoppingListNotFoundException;
import pl.wsb.shoppingList.error.UnitNotFoundException;
import pl.wsb.shoppingList.model.Unit;
import pl.wsb.shoppingList.repository.UnitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

	private final UnitRepository unitRepository;

	public UnitService(UnitRepository unitRepository) {
		this.unitRepository = unitRepository;
	}

	public List<Unit> findAllUnits() {
		return unitRepository.findAll();
	}

	public Unit findUnitById(String id) {
		return unitRepository.findById(Long.parseLong(id))
				.orElseThrow(() -> new UnitNotFoundException(Long.parseLong(id)));
	}

	public Unit createUnit(Unit unit) {
		return unitRepository.save(unit);
	}

	public Unit updateUnit(Unit newUnit, String id) {
		return unitRepository.findById(Long.parseLong(id))
				.map(unit -> {
					unit.setId(newUnit.getId());
					unit.setSymbol(newUnit.getSymbol());
					return unitRepository.save(unit);
				})
				.orElseThrow(() -> new UnitNotFoundException(Long.parseLong(id)));
	}

	public void deleteUnit(String id) {
		unitRepository.deleteById(Long.parseLong(id));
	}
}

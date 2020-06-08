package pl.wsb.service;

import org.springframework.stereotype.Service;
import pl.wsb.model.Unit;
import pl.wsb.repository.UnitRepository;
import pl.wsb.error.UnitNotFoundException;

import java.util.List;

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

package pl.wsb.shoppingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.shoppingList.model.Product;
import pl.wsb.shoppingList.model.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
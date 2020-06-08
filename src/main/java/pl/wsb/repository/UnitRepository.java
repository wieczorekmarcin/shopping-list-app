package pl.wsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.model.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
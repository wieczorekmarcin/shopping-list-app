package pl.wsb.shoppingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.shoppingList.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
package pl.wsb.shoppingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.shoppingList.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
package mate.dao;

import java.util.List;
import java.util.Optional;
import mate.model.Product;

public interface ProductDao {
    Product save(Product product);

    Optional<Product> get(Long id);

    List<Product> findAll();

    List<Product> findByBrand(String brand);
}

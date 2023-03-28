package mate.dao;

import java.util.List;
import mate.model.Product;

public interface ProductDao {
    Product save(Product product);

    Product get(Long id);

    List<Product> findAll();

    List<Product> findByBrand(String brand);
}

package mate.dao;

import java.util.List;
import mate.model.Product;

public interface ProductDao {
    Product save(Product product);

    List<Product> findAll();
}

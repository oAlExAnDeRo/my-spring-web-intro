package mate.service;

import java.util.List;
import mate.model.Product;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();
}

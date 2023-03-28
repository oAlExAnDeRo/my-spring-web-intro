package mate.service;

import java.util.List;
import mate.model.Product;

public interface ProductService {
    Product save(Product product);

    Product get(Long id);

    List<Product> findAll();

    List<Product> findByBrand(String brand);

}

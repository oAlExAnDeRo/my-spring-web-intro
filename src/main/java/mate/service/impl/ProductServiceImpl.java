package mate.service.impl;

import java.util.List;
import mate.dao.ProductDao;
import mate.model.Product;
import mate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return productDao.findByBrand(brand);
    }

    @Override
    public Product get(Long id) {
        return productDao.get(id);
    }
}

package mate.service.impl;

import mate.dao.CategoryDao;
import mate.model.Category;
import mate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category get(Long id) {
        return categoryDao.get(id).orElseThrow(
                () -> new RuntimeException("Can't get categoryId" + id));
    }
}

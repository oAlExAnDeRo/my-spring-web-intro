package mate.dao;

import mate.model.Category;

public interface CategoryDao {
    Category save(Category category);

    Category get(Long id);
}

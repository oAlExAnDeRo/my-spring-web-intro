package mate.dao;

import java.util.Optional;
import mate.model.Category;

public interface CategoryDao {
    Category save(Category category);

    Optional<Category> get(Long id);
}

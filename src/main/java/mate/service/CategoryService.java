package mate.service;

import mate.model.Category;

public interface CategoryService {
    Category save(Category category);

    Category get(Long id);
}

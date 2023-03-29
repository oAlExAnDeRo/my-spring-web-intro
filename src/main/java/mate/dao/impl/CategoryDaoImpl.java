package mate.dao.impl;

import java.util.Optional;
import mate.dao.CategoryDao;
import mate.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Category save(Category category) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't save category to DB: " + category, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return category;
    }

    @Override
    public Optional<Category> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Category.class, id));
        } catch (Exception e) {
            throw new RuntimeException("Can't get category from DB by id", e);
        }
    }
}

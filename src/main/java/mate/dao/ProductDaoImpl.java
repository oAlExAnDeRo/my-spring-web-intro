package mate.dao;

import java.util.List;
import mate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't save product to DB: " + product, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> getAllProductQuery = session
                    .createQuery("from Product", Product.class);
            return getAllProductQuery.getResultList();
        }
    }
}

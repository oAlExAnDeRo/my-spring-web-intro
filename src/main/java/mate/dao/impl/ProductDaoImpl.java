package mate.dao.impl;

import java.util.List;
import java.util.Optional;
import mate.dao.ProductDao;
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
            session.save(product);
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
    public Optional<Product> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Product.class, id));
        } catch (Exception e) {
            throw new RuntimeException("Can't get product from DB by id: " + id, e);
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> getAllProductQuery = session
                    .createQuery("from Product", Product.class);
            return getAllProductQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of products from DB", e);
        }
    }

    @Override
    public List<Product> findByBrand(String brand) {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> queryByBrand = session
                    .createQuery("from Product p where p.brand = :brand", Product.class)
                    .setParameter("brand", brand);
            return queryByBrand.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get brand from DB: " + brand, e);
        }
    }
}

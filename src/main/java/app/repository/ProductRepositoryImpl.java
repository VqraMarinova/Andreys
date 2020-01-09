package app.repository;

import app.domain.entities.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager entityManager;

    @Inject
    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Product product) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(product);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<Product> findAll() {
        this.entityManager.getTransaction().begin();
        List<Product> products = this.entityManager.createQuery(
                "SELECT p FROM Product p", Product.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return products;
    }

    @Override
    public Product findById(String id) {
        this.entityManager.getTransaction().begin();
        Product product = this.entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM Product p WHERE p.id =:id")
                .setParameter("id",id).executeUpdate();
        this.entityManager.getTransaction().commit();
    }
}

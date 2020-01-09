package app.repository;

import app.domain.entities.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    List<Product> findAll();

    Product findById(String id);

    void delete(String id);
}

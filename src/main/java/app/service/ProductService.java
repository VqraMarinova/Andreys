package app.service;

import app.domain.models.service.ProductServiceModel;

import java.util.List;

public interface ProductService {

    void save(ProductServiceModel product);

    List<ProductServiceModel> getAll();

    ProductServiceModel getById(String id);

    void delete(String id);
}

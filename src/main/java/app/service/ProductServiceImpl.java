package app.service;


import app.domain.entities.Product;
import app.domain.models.service.ProductServiceModel;
import app.repository.ProductRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(ProductServiceModel product) {
        this.productRepository.save(this.modelMapper.map(product, Product.class));
    }

    @Override
    public List<ProductServiceModel> getAll() {
        return this.productRepository.findAll()
                .stream()
                .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductServiceModel getById(String id) {
        return this.modelMapper.map(this.productRepository.findById(id), ProductServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.productRepository.delete(id);
    }
}

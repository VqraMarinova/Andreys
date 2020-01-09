package app.web;

import app.domain.models.view.ProductViewModel;
import app.service.ProductService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class ProductListBean {

    private List<ProductViewModel> products;
    private ProductService productService;
    private ModelMapper modelMapper;

    public ProductListBean() {
    }

    @Inject
    public ProductListBean(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.setProducts(this.productService.getAll().stream()
                .map(p -> this.modelMapper.map(p, ProductViewModel.class))
                .collect(Collectors.toList()));
        this.getProducts().forEach(p -> p.setCategory(p.getCategory()));
        this.getProducts().forEach(p -> p.setSex(p.getSex()));
    }

    public List<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewModel> products) {
        this.products = products;
    }
}

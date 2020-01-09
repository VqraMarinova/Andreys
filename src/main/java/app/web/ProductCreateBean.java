package app.web;

import app.domain.entities.Category;
import app.domain.entities.Sex;
import app.domain.models.binding.ProductCreateBindingModel;
import app.domain.models.service.ProductServiceModel;
import app.service.ProductService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ProductCreateBean extends BaseBean {

    private ProductCreateBindingModel productCreateBindingModel;
    private ProductService productService;
    private ModelMapper modelMapper;

    public ProductCreateBean() {
    }

    @Inject
    public ProductCreateBean(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.productCreateBindingModel = new ProductCreateBindingModel();
    }

    public void create(){
        ProductServiceModel model = this.modelMapper.map(this.productCreateBindingModel, ProductServiceModel.class);
        Category category = null;
        Sex sex = null;
        try {
            category = Category.valueOf(this.productCreateBindingModel.getCategory().toUpperCase());
            sex = Sex.valueOf(this.productCreateBindingModel.getSex().toUpperCase());
        } catch (Exception e) {
            this.redirect("/add-job");
        }
        model.setCategory(category);
        model.setSex(sex);

        this.productService.save(model);
        this.redirect("/home");
    }

    public ProductCreateBindingModel getProductCreateBindingModel() {
        return productCreateBindingModel;
    }

    public void setProductCreateBindingModel(ProductCreateBindingModel productCreateBindingModel) {
        this.productCreateBindingModel = productCreateBindingModel;
    }
}

package app.web;

import app.domain.models.view.ProductViewModel;
import app.service.ProductService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class DetailsBean extends BaseBean {

    private ProductService productService;
    private ModelMapper modelMapper;

    public DetailsBean() {
    }

    @Inject
    public DetailsBean(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    public ProductViewModel getProductById(String id){
        return this.modelMapper.map(this.productService.getById(id), ProductViewModel.class);
    }

    public void delete(){
        String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.productService.delete(id);
        this.redirect("/home");
    }

}

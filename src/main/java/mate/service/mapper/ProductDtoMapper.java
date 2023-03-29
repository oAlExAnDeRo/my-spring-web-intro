package mate.service.mapper;

import mate.model.Product;
import mate.model.dto.ProductRequestDto;
import mate.model.dto.ProductResponseDto;
import mate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {
    @Autowired
    private CategoryService categoryService;

    public ProductResponseDto parse(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setBrand(product.getBrand());
        //responseDto.setCategoryId(product.getCategory().getId());
        return responseDto;
    }

    public Product toModel(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setBrand(requestDto.getBrand());
        product.setName(requestDto.getName());
        product.setPrice(requestDto.getPrice());
        //product.setCategory(categoryService
        //.get(requestDto.getCategoryId()));
        return product;
    }
}

package mate.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import mate.model.Product;
import mate.model.dto.ProductResponseDto;
import mate.service.ProductService;
import mate.service.mapper.ProductDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;

    public ProductController(ProductService productService,
                             ProductDtoMapper productDtoMapper) {
        this.productService = productService;
        this.productDtoMapper = productDtoMapper;
    }

    @GetMapping("/")
    public List<ProductResponseDto> getAllProducts() {
        return productService.findAll()
                .stream()
                .map(productDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductResponseDto get(@PathVariable Long id) {
        return productDtoMapper.parse(productService.get(id));
    }

    @GetMapping("/find")
    public List<ProductResponseDto> getAllByBrand(@RequestParam String brand) {
        return productService.findByBrand(brand)
                .stream()
                .map(productDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String injectMockData() {
        Product iphone = new Product();
        iphone.setName("iPhone 7");
        iphone.setBrand("Apple");
        iphone.setPrice(BigDecimal.valueOf(499));

        Product samsung = new Product();
        samsung.setName("Samsung S20");
        samsung.setBrand("Samsung");
        samsung.setPrice(BigDecimal.valueOf(699));

        Product samsung10 = new Product();
        samsung10.setName("Samsung S10");
        samsung10.setBrand("Samsung");
        samsung10.setPrice(BigDecimal.valueOf(599));

        productService.save(iphone);
        productService.save(samsung);
        productService.save(samsung10);
        return "Mock data injected successfully";
    }
}

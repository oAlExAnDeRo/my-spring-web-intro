package mate;

import java.math.BigDecimal;
import mate.model.Product;
import mate.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*
            Steps to implement:
            1. Add <packaging>war</packaging> to pom.xml
            2. Add spring-webmvc dependency to pom.xml
            3. Add javax.servlet-api dependency to pom.xml (jakarta)
            4. Add maven-war-plugin plugin to pom.xml
            5. Create WebConfig class with @EnableWebMvc,
                @Configuration and @ComponentScan annotations
            6. Create WebAppInitializer extends
                AbstractAnnotationConfigDispatcherServletInitializer class
            7. Create controller
            8. Create add jsp page to src/main/webapp/WEB-INF/views/index.jsp
            9. Implement WebMvcConfigurer interface in the WebConfig class
            10. Configure InternalResourceViewResolver bean in the WebConfig class
            11. Add javax.servlet.jsp-api dependency to pom.xml
            12. Add javax.servlet.jsp.jstl-api dependency to pom.xml
            13. Add taglibs standard dependency to pom.xml
            14.Configure Tomcat and run app
         */

        // create products
        Product iphone = new Product();
        iphone.setName("iPhone 7");
        iphone.setPrice(BigDecimal.valueOf(499));

        Product samsung = new Product();
        samsung.setName("Samsung S20");
        samsung.setPrice(BigDecimal.valueOf(699));

        Product samsung10 = new Product();
        samsung10.setName("Samsung S10");
        samsung10.setPrice(BigDecimal.valueOf(599));

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        ProductService productService = context.getBean(ProductService.class);

        productService.save(iphone);
        productService.save(samsung);
        productService.save(samsung10);

        productService.findAll().forEach(System.out::println);
    }
}

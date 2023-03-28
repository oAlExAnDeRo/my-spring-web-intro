package mate;

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
    }
}

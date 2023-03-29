package mate.controller;

import java.time.LocalDateTime;
import mate.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Hello Spring!");
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/time")
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }

    @ResponseBody
    @GetMapping("/phone")
    public Product getProduct() {
        return null; //new Product(1L, "iPhone 7", BigDecimal.valueOf(599));
    }
}

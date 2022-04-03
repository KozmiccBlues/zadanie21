package pl.akoz.zadanie21;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/lista")
    public String home(Model model, @RequestParam(required = false, name = "kategoria") Category category) {
        Set<Product> products;

        if (category != null) {
            products = productRepository.findByCategory(category);

        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("kategoria", products);

        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();

            model.addAttribute("priceSum", sum);
            
        }
        return "lista";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }
    @PostMapping("/add")
    public String add(Product product) {
        productRepository.add(product);

        return "redirect:/lista";

    }
}

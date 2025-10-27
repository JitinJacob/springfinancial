package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/generate")
  public List<Product> generateProducts(@RequestParam(defaultValue = "100") int count) {
    return productService.generateProducts(count);
  }

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/search")
  public List<Product> searchProducts(@RequestParam("query") String query) {
    return productService.searchProducts(query);
  }

  @GetMapping("/filter")
  public List<Product> filterProducts(@RequestParam("query") String query) {
    return productService.filterProducts(query);
  }
}


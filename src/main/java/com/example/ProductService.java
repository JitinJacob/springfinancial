package com.example;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final Random random = new Random();

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional
  public List<Product> generateProducts(int count) {
    productRepository.deleteAll();

    for (int i = 0; i < count; i++) {
      Product product = new Product(
          "Product-" + i,
          "Description for product " + i,
          "Brand-" + (i % 3),
          randomCategory(),
          UUID.randomUUID().toString().substring(0, 8)
      );
      productRepository.save(product);
    }

    return productRepository.findAll();
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }


  public List<Product> searchProducts(String query) {
    return productRepository.searchProducts(query);
  }


  public List<Product> filterProducts(String query) {
    if (query == null || query.trim().isEmpty()) {
      return productRepository.findAll();
    }
    return productRepository.filterProducts(query.trim());
  }

  private String randomCategory() {
    String[] categories = {"Electronics", "Clothing", "Books", "Home", "Toys"};
    return categories[random.nextInt(categories.length)];
  }
}

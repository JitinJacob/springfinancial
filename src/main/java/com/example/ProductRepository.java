package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("""
        SELECT p FROM Product p
        WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))
           OR LOWER(p.description) LIKE LOWER(CONCAT('%', :query, '%'))
           OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :query, '%'))
           OR LOWER(p.category) LIKE LOWER(CONCAT('%', :query, '%'))
           OR LOWER(p.sku) LIKE LOWER(CONCAT('%', :query, '%'))
    """)
  List<Product> searchProducts(@Param("query") String query);


  @Query("""
        SELECT p FROM Product p
        WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))
           OR LOWER(p.description) LIKE LOWER(CONCAT('%', :query, '%'))
           OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :query, '%'))
           OR LOWER(p.category) LIKE LOWER(CONCAT('%', :query, '%'))
           OR LOWER(p.sku) LIKE LOWER(CONCAT('%', :query, '%'))
    """)
  List<Product> filterProducts(@Param("query") String query);
}



package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private String brand;
  private String category;
  private String sku;

  public Product() {}

  public Product(String name, String description, String brand, String category, String sku) {
    this.name = name;
    this.description = description;
    this.brand = brand;
    this.category = category;
    this.sku = sku;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getBrand() {
    return brand;
  }

  public String getCategory() {
    return category;
  }

  public String getSku() {
    return sku;
  }
}


# 🛍️ Product Search API — Spring Boot (Java 21)

A **Spring Boot** application built with **Java 21**, **Gradle**, and an **H2 in-memory database**.  
This project provides REST APIs to **generate**, **list**, and **search** products.  
The search endpoint performs **backend filtering** against multiple fields — `name`, `description`, `brand`, `category`, and `sku`.

---

## 🚀 Features

- ✅ **Generate sample products** dynamically
- ✅ **Retrieve all products**
- ✅ **Search products** by query text across multiple fields
- ✅ **Case-insensitive partial search**
- ✅ **In-memory H2 database** (auto-configured)
- ✅ Built using **Java 21**, **Spring Boot 3+**, **Gradle (Groovy DSL)**

---

## 🧩 Tech Stack

| Component | Technology |
|------------|-------------|
| Language | Java 21 |
| Framework | Spring Boot 3.x |
| Build Tool | Gradle (Groovy DSL) |
| Database | H2 (in-memory) |
| ORM | Spring Data JPA |
| REST | Spring Web |
| Testing | JUnit 5 |

---

Using Gradle
./gradlew bootRun


The API will start on:
👉 http://localhost:8080


Generate Sample Products

POST /products/generate

Generates a given number of sample products (default: 5).

Example
```curl -X POST "http://localhost:8080/products/generate?count=5"```

Response
````
[
{
"id": 1,
"name": "Product 1",
"description": "Description for product 1",
"brand": "Brand-1",
"category": "Category-2",
"sku": "d3a7f29b"
},
...
]
````

Get All Products

GET /products

Fetch all existing products.

Example
```curl http://localhost:8080/products```

Response
````
[
{
"id": 1,
"name": "Product 1",
"description": "Description for product 1",
"brand": "Brand-1",
"category": "Category-2",
"sku": "d3a7f29b"
}
]
````

Filter Products

GET /products/filter?query=<searchTerm>

Performs case-insensitive search across name, description, brand, category, and sku.

Example
```curl "http://localhost:8080/products/filter?query=brand-1"```

Response
````
[
{
"id": 2,
"name": "Product 2",
"description": "Description for product 2",
"brand": "Brand-1",
"category": "Category-2",
"sku": "e23a12bc"
}
]
````

Search Products
```curl "http://localhost:8080/products/search?query=brand-1"```

Example Response
````
[
{
"id": 2,
"name": "Product-1",
"description": "Description for product 1",
"brand": "Brand-1",
"category": "Electronics",
"sku": "b74ac5ef"
}
]
````

Assumptions

“Dynamic filter” = single free-text query matched across name, description, category, brand, SKU; numeric tokens match price/stock exactly.

Pagination + sort are required for snappy UX with 100–1000 rows.

Performance choices

H2 with indices on search columns for LIKE scans; paging limits to ≤100 items.

Batched inserts enabled to generate up to 1k quickly.

Improvements with more time

Multi-facet filters (price range, category list, stock > 0), fuzzy match, and highlighting.

Full-text via PostgreSQL GIN/tsvector or Elasticsearch/OpenSearch if scale grows.

Caching hot queries, rate-limiting, metrics, and tracing.

Contract tests + controller slice tests + testcontainers against Postgres.

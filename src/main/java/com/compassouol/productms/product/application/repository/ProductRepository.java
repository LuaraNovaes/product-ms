package com.compassouol.productms.product.application.repository;

import java.util.List;
import java.util.Optional;

import com.compassouol.productms.product.domain.Product;
import com.compassouol.productms.product.domain.ProductFilters;

public interface ProductRepository {
	Product save(Product product);
	Optional<Product> findById(String id);
	List<Product> findAll();
	void delete(Product findById);
	List<Product> findAll(ProductFilters filters);
}

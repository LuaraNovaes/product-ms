package com.compassouol.productms.product.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.compassouol.productms.product.domain.Product;

public interface ProductRepository {
	Product save(Product product);
	Optional<Product> findById(String idProduct);
	List<Product> findAll(Product product);
	Optional<Product> findById(UUID id);
}

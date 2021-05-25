package com.compassouol.productms.product.application.repository;

import java.util.Optional;

import com.compassouol.productms.product.domain.Product;

public interface ProductRepository {
	Product save(Product product);
	Optional<Product> findById(String idProduct);
}

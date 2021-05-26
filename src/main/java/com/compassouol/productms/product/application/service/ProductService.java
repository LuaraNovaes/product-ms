package com.compassouol.productms.product.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.compassouol.productms.product.domain.Product;

@Service
public interface ProductService {

	Product savedProduct(Product Product);

	Product findById(String id);

	List<Product> findAll();

	Product update(String id, Product productByForm);

}

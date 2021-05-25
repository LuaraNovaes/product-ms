package com.compassouol.productms.product.application.service;

import org.springframework.stereotype.Service;

import com.compassouol.productms.product.application.repository.ProductRepository;
import com.compassouol.productms.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class ProductSpringDataJPAService implements ProductService {
	private ProductRepository productRepository;

	@Override
	public Product savedProduct(Product product) {
		log.info("[Start] ProductSpringDataJPAService - saveProduct");
		this.productRepository.save(product);
		log.info("[Finishes] ProductSpringDataJPAService - saveProduct");
		return product;
	}
}

package com.compassouol.productms.product.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.compassouol.productms.handler.ApiException;
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
		log.info("[Finish] ProductSpringDataJPAService - saveProduct");
		return product;
	}

	@Override
	public Product findById(String idProduct) {
		log.info("[Start] ProductSpringDataJPAService - findById");
       Product productById = productRepository.findById(idProduct)
       .orElseThrow(() -> ApiException.throwApiException(HttpStatus.NOT_FOUND, "Product not found!"));
       log.info("[Finish] ProductSpringDataJPAService - findById");
		return productById;
	}
}

package com.compassouol.productms.product.application.service;

import java.util.List;

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

	@Override
	public List<Product> findAll(Product product) {
		List<Product> allProducts = productRepository.findAll(product);
		return allProducts;
	}

	@Override
	public Product update(Product buildProduct) {
		Product productById = productRepository.findById(buildProduct.getId());
		productById.update(buildProduct);
		productRepository.save(productById);
		return productById;
	}
}

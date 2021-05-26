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
	public Product findById(String id) {
		log.info("[Start] ProductSpringDataJPAService - findById");
		Product productById = productRepository.findById(id)
				.orElseThrow(() -> ApiException.throwApiException(HttpStatus.NOT_FOUND, "Product not found!"));
		log.info("[Finish] ProductSpringDataJPAService - findById");
		return productById;
	}

	@Override
	public List<Product> findAll() {
		log.info("[Start] ProductSpringDataJPAService - findAll");
		List<Product> allProducts = productRepository.findAll();
		log.info("[Finish] ProductSpringDataJPAService - findAll");
		return allProducts;
	}

	@Override
	public Product update(String id, Product productByForm) {
		log.info("[Start] ProductSpringDataJPAService - update");
		Product productById = this.findById(id);
		productById.update(productByForm);
		productRepository.save(productById);
		log.info("[Finish] ProductSpringDataJPAService - update");
		return productById;
	}

	@Override
	public void deleteById(String id) {
		log.info("[Start] ProductRestController - delete");
		log.info("Parameter:{}",id);
		log.info("Deleting product id  on productRepository");
		productRepository.delete(this.findById(id));
		log.info("[Finish] ProductRestController - delete");
	}
}

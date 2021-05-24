package com.compassouol.productms.product.application.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.compassouol.productms.handler.ApiException;
import com.compassouol.productms.product.application.repository.ProductRepository;
import com.compassouol.productms.product.domain.Product;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class ProductSpringDataJPAService implements ProductService {
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product entityProduct) {
		log.info("[Start] ProductSpringDataJPAService - saveProduct");
		saveToRepository(entityProduct);
		log.info("[Finishes] ProductSpringDataJPAService - saveProduct");
		return entityProduct;
	}

	private Product saveToRepository(Product entityProduct) {
		log.info("[Start] ProductSpringDataJPAService - saveToRepository");
		try {
			Product savedProduct = this.productRepository.save(entityProduct);
			log.info("[Finishes] ProductSpringDataJPAService - saveToRepository");
			return savedProduct;
		} catch (DataIntegrityViolationException e) {
			throw ApiException.throwApiException(HttpStatus.BAD_REQUEST,
					"Número já utilizado por outro product", e);
			//TODO ver sobre essa exceção de negócio e ver também sobre idioma
		}		
	}

}

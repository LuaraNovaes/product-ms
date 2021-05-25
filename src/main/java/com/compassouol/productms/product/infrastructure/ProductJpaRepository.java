package com.compassouol.productms.product.infrastructure;

import org.springframework.stereotype.Component;

import com.compassouol.productms.product.application.repository.ProductRepository;
import com.compassouol.productms.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class ProductJpaRepository implements ProductRepository {
	private final ProductSpringDataJpaRepository productSpringDataJpaRepository;

	@Override
	public Product save(Product product) {
		log.info("[Start] ProductJpaRepository - save");
		Product savedProduct = this.productSpringDataJpaRepository.save(product);
		log.info("[Finishes] ProductJpaRepository - save");
		return savedProduct;
	}
}

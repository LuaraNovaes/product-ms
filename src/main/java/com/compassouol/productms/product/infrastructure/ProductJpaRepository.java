package com.compassouol.productms.product.infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

	@Override
	public Optional<Product> findById(String id) {
		return productSpringDataJpaRepository.findById(UUID.fromString(id));
	}

	@Override
	public List<Product> findAll() {
		return productSpringDataJpaRepository.findAll();
	}

	@Override
	public void delete(Product findById) {
       this.productSpringDataJpaRepository.delete(findById);		
	}

}

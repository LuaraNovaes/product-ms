package com.compassouol.productms.product.infrastructure;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.compassouol.productms.product.domain.Product;

public class ProductSpecification {
	public static Specification<Product> name(String name) {
		return Optional.ofNullable(name)
				.map(n -> getName(n))
				.orElse(productDisjunction());
	}

	public static Specification<Product> getName(String name) {
		return (product, criteriaQuery, criteriaBuilder) 
				-> criteriaBuilder.like(product.get("name"), "%" + name + "%");
	}

	public static Specification<Product> description(String description) {
		return Optional.ofNullable(description)
				.map(d -> getDescription(d))
				.orElse(productDisjunction());
	}
	
	public static Specification<Product> getDescription(String description) {
		return (product, criteriaQuery, criteriaBuilder) 
				-> criteriaBuilder.like(product.get("description"),"%" + description + "%");
	}

	public static Specification<Product> minPrice(BigDecimal price) {
		return Optional.ofNullable(price)
				.map(p -> getMinPrice(p))
				.orElse(productConjunction());
	}

	private static Specification<Product> getMinPrice(BigDecimal price) {
		return (product, criteriaQuery, criteriaBuilder) 
				-> criteriaBuilder.greaterThanOrEqualTo(product.get("price"), price);
	}

	public static Specification<Product> maxPrice(BigDecimal price) {
		return Optional.ofNullable(price)
				.map(p -> getMaxPrice(p))
				.orElse(productConjunction());
	}

	public static Specification<Product> getMaxPrice(BigDecimal price) {
		return (product, criteriaQuery, criteriaBuilder) 
				-> criteriaBuilder.lessThanOrEqualTo(product.get("price"), price);
	}

	private static Specification<Product> productConjunction() {
		return (product, criteriaQuery, criteriaBuilder) ->
				criteriaBuilder.conjunction();
	}
	
	private static Specification<Product> productDisjunction() {
		return (product, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.disjunction();
	}
}
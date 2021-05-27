package com.compassouol.productms.product.domain;

import static com.compassouol.productms.product.infrastructure.ProductSpecification.description;
import static com.compassouol.productms.product.infrastructure.ProductSpecification.maxPrice;
import static com.compassouol.productms.product.infrastructure.ProductSpecification.minPrice;
import static com.compassouol.productms.product.infrastructure.ProductSpecification.name;
import static org.springframework.data.jpa.domain.Specification.where;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ProductFilters {
	private String query;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;

	public Specification<Product> buildSpecification() {
		return where((name(query).or(description(query)))
				.and(minPrice(minPrice))
				.and(maxPrice(maxPrice)));
	}
}

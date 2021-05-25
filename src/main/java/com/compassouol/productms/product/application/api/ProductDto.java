package com.compassouol.productms.product.application.api;

import java.math.BigDecimal;
import java.util.UUID;

import com.compassouol.productms.product.domain.Product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ProductDto {
	private UUID id;
	private String name;
	private String description;
	private BigDecimal price;

	public static ProductDto buildByEntity(Product product) {
		return ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}

}

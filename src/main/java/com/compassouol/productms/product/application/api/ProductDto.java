package com.compassouol.productms.product.application.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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


	public static List<ProductDto> parseListDTO(List<Product> products) {
		return products.stream().map(ProductDto::new).collect(Collectors.toList());
	}

	public ProductDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}
}

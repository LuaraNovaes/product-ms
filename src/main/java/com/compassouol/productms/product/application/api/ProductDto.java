package com.compassouol.productms.product.application.api;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ProductDto {
	private UUID id;
	private String name;
	private String description;
	private BigDecimal price;
}

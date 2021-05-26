package com.compassouol.productms.product.application.api;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.compassouol.productms.product.domain.Product;

public class ProductUpdateForm {
	@NotNull(message = "name empty")
	@NotBlank(message = "name empty")
	private String name;

	@NotNull(message = "description notnull")
	@NotBlank(message = "description empty")
	private String description;

//	@NotNull(message = "price notnull")
	private BigDecimal price;

	public Product buildProduct(String idProduct) {
		return Product.builder()
				.name(this.name)
				.description(this.description)
				.price(price)
				.build();
	}
	//TODO Validar o valor positivo
	
	
}

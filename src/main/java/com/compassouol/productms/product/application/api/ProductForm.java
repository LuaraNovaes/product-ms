package com.compassouol.productms.product.application.api;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.compassouol.productms.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@Valid
@AllArgsConstructor
public class ProductForm {
	@NotNull(message = "name empty")
	@NotBlank(message = "name empty")
	private String name;

	@NotNull(message = "description notnull")
	@NotBlank(message = "description empty")
	private String description;

	@NotNull(message = "price notnull")
	@NotBlank(message = "price empty")
	private BigDecimal price;
	//TODO Validar o valor positivo

	public Product toEntityProduct() {
		return Product.builder()
				.name(this.name)
				.description(this.description)
				.build();
	}
}

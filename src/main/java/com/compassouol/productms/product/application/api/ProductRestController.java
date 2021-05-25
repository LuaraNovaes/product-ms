package com.compassouol.productms.product.application.api;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compassouol.productms.product.application.service.ProductService;
import com.compassouol.productms.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@AllArgsConstructor
@Log4j2
public class ProductRestController implements ProductAPI {
	private ProductService productService;

	@Override
	public ResponseEntity<ProductDto> create(@Valid ProductForm productDTO, UriComponentsBuilder uriBuilder) {
		log.info("[Start] ProductRestController - create");
		Product product = productService.savedProduct(productDTO.toEntityProduct());
		log.info("produto {} salvo!", product.toString());
		URI uri = uriBuilder.path("/productms/app/v1/product/{productId}").buildAndExpand(product.getId()).toUri();
		log.info("[Finishes] ProductRestController - create");
		return ResponseEntity.created(uri).body(ProductDto.buildByEntity(product));
	}

}

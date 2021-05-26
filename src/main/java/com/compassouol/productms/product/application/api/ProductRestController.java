package com.compassouol.productms.product.application.api;

import java.net.URI;
import java.util.List;

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
		log.info("[Finish] ProductRestController - create");
		return ResponseEntity.created(uri).body(ProductDto.buildByEntity(product));
	}

	@Override
	public ProductDto findById(String id) {
		log.info("[Start] ProductRestController - findById");
           Product product = productService.findById(id);
           log.info("[Finish] ProductRestController - findById");
		return ProductDto.buildByEntity(product);
	}

	@Override
	public List<ProductDto> findAll() {
		log.info("[Start] ProductRestController - findAll");
        List<Product> products = productService.findAll();
        log.info("[Finish] ProductRestController - findAll");
		return ProductDto.parseListDTO((List<Product>) products);
	}

	@Override
	public ProductDto update(String id, @Valid ProductUpdateForm updateForm) {
		log.info("[Start] ProductRestController - update");
		Product product = productService.update(id,updateForm.buildProduct(id));
		log.info("[Finish] ProductRestController - update");
		return new ProductDto(product);
	}



}

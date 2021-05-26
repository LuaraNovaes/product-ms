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
	public ProductDto findById(String idProduct) {
		log.info("[Start] ProductRestController - findById");
           Product product = productService.findById(idProduct);
           log.info("[Finish] ProductRestController - findById");
		return ProductDto.buildByEntity(product);
	}

	@Override
	public List<ProductDto> findAll(Product product) {
        List<Product> products = productService.findAll(product);
		return ProductDto.parseListDTO((List<Product>) products);
	}

	@Override
	public ProductDto update(String idProduct, @Valid ProductUpdateForm updateForm) {
		Product product = productService.update(updateForm.buildProduct(idProduct));
		log.info("Finishing Method Update in Client Controller!");
		return new ProductDto(product);
	}



}

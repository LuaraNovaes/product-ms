package com.compassouol.productms.product.application.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compassouol.productms.product.domain.Product;

@RestController
@RequestMapping("products")
public interface ProductAPI {
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductForm productForm, UriComponentsBuilder uriBuilder);
	
	@GetMapping("/products/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	ProductDto findById(@PathVariable String idProduct);
	
	@GetMapping("/products")
	@ResponseStatus(value = HttpStatus.OK)
	List<ProductDto> findAll(Product product);
	
	@PutMapping("/products/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	ProductDto update(@RequestParam String idProduct,@RequestBody @Valid ProductUpdateForm updateForm);
}

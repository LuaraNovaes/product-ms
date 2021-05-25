package com.compassouol.productms.product.application.service;

import org.springframework.stereotype.Service;

import com.compassouol.productms.product.domain.Product;

@Service
public interface ProductService {

	Product savedProduct(Product Product);

	Product findById(String idProduct);


}

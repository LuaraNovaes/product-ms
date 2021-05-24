package com.compassouol.productms.product.infrastructure;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compassouol.productms.product.domain.Product;

public interface ProductSpringDataJpaRepository extends JpaRepository<Product, UUID> {

}

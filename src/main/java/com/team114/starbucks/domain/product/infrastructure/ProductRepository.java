package com.team114.starbucks.domain.product.infrastructure;

import com.team114.starbucks.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Boolean existsByName(String name);

    Product findByUuid(String uuid);




}

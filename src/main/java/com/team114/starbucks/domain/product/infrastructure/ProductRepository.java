package com.team114.starbucks.domain.product.infrastructure;

import com.team114.starbucks.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductUuid(String productUuid);

    Optional<Product> deleteByProductUuid(String productUuid);

}

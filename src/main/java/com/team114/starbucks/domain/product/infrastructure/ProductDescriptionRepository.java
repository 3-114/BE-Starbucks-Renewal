package com.team114.starbucks.domain.product.infrastructure;

import com.team114.starbucks.domain.product.entity.ProductDescription;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, Long> {

    Optional<ProductDescription> findByProductUuid(String productUuid);
    void deleteByProductUuid(String productUuid);

}

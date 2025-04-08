package com.team114.starbucks.domain.product.infrastructure;

import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductThumbnailRepository extends JpaRepository<ProductThumbnail, Long> {

    List<ProductThumbnail> findByProductUuid(String productUuid);

    List<ProductThumbnail> findByProductId(Long productId);

}

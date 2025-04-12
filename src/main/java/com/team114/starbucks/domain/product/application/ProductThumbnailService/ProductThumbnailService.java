package com.team114.starbucks.domain.product.application.ProductThumbnailService;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductThumbnailService {

    List<ProductThumbnail> getProductThumbnailById(Product product);

    void saveAllProductThumbnail(Product product, List<ProductThumbnail> productThumbnailList);




}

package com.team114.starbucks.domain.product.application.ProductThumbnailService;

import com.team114.starbucks.domain.product.dto.in.CreateProductThumbnailReqDto;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;

import java.util.List;

public interface ProductThumbnailService {

    List<ProductThumbnail> getProductThumbnailById(Product product);

    void saveAllProductThumbnail(Product product, List<CreateProductThumbnailReqDto> productThumbnailList);

}
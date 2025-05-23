package com.team114.starbucks.domain.product.application.ProductThumbnailService;

import com.team114.starbucks.domain.product.dto.in.CreateProductThumbnailReqDto;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
import com.team114.starbucks.domain.product.infrastructure.ProductThumbnailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductThumbnailServiceImpl implements ProductThumbnailService {

    private final ProductThumbnailRepository productThumbnailRepository;
    private final ProductRepository productRepository;

    @Override
    public List<ProductThumbnail> getProductThumbnailById(Product product) {
        productRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + product.getId()));

        return productThumbnailRepository.findByProductId(product.getId());
    }

    @Override
    public void saveAllProductThumbnail(Product product, List<CreateProductThumbnailReqDto> productThumbnailList) {
        productRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + product.getId()));

        List<ProductThumbnail> list = new ArrayList<>();
        for (CreateProductThumbnailReqDto thumbnail : productThumbnailList) {
            list.add(thumbnail.toEntity(product));
        }
        productThumbnailRepository.saveAll(list);
    }

}
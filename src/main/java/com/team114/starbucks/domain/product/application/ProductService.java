package com.team114.starbucks.domain.product.application;


import com.team114.starbucks.domain.product.dto.in.ProductPostReqDto;
import com.team114.starbucks.domain.product.dto.out.ProductGetResDto;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;


    public List<ProductGetResDto> getAllProducts() {

        List<Product> productList = productRepository.findAll();

        List<ProductGetResDto> responseList =  new ArrayList<>();

        for (Product product : productList) {
            ProductGetResDto dto = ProductGetResDto.from(product);
            responseList.add(dto);
        }

        return responseList;
    }

    public ProductGetResDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

        ProductGetResDto dto = ProductGetResDto.from(product);

        return dto;

    }

    @Transactional(readOnly = false)
    public ProductPostReqDto saveProduct(ProductPostReqDto productPostReqDto) {

        //Product product = productPostReqDto.toEntity();

        Product product = Product.builder()
                .name(productPostReqDto.getName())
                .price(productPostReqDto.getPrice())
                .build();

        productRepository.save(product);

        return productPostReqDto;



    }


}

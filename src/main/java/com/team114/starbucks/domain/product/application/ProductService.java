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
import java.util.UUID;

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
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

        ProductGetResDto dto = ProductGetResDto.from(product);

        return dto;

    }

    @Transactional(readOnly = false)
    public ProductPostReqDto saveProduct(ProductPostReqDto productPostReqDto) {

        //Product product = productPostReqDto.toEntity();

        if (productRepository.existsByName(productPostReqDto.getProductName())) {
            throw new IllegalArgumentException("이미 존재하는 상품입니다.");
        }

        Product product = Product.builder()
                .productUuid(UUID.randomUUID().toString()) // ✅ UUID 자동 생성
                .productName(productPostReqDto.getProductName())
                .productPrice(productPostReqDto.getProductPrice())
                .brand(productPostReqDto.getBrand()) // brand도 들어간다면 추가
                .description(productPostReqDto.getDescription()) // 필요 시 추가
                .productStatus(productPostReqDto.getProductStatus()) // 필요 시 추가
                .shippingFee(productPostReqDto.getShippingFee()) // 필요 시 추가
                .build();


        productRepository.save(product);

        return productPostReqDto;


    }


}

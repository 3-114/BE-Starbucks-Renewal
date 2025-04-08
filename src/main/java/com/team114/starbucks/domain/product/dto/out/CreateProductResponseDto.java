package com.team114.starbucks.domain.product.dto.out;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.Brand;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.out.CreateProductResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateProductResponseDto {

    private String productName;
    private Brand brand;
    private Integer productPrice;
    private String description;
    private Integer shippingFee;
    private ProductStatus productStatus;
    private String productUuid;

    @Builder
    public CreateProductResponseDto(
            String productName,
            Brand brand,
            Integer productPrice,
            String description,
            Integer shippingFee,
            ProductStatus productStatus,
            String productUuid
    ) {
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.description = description;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
        this.productUuid = productUuid;
    }

    // dto <- entity 정적 팩토리 메서드
    public static CreateProductResponseDto from(Product savedProduct) {
        return CreateProductResponseDto.builder()
                .productName(savedProduct.getProductName())
                .brand(savedProduct.getBrand())
                .productPrice(savedProduct.getProductPrice())
                .description(savedProduct.getDescription())
                .shippingFee(savedProduct.getShippingFee())
                .productStatus(savedProduct.getProductStatus())
                .productUuid(savedProduct.getProductUuid())
                .build();
    }

    // dto -> vo
    public CreateProductResponseVo toVo() {
        return CreateProductResponseVo.builder()
                .productName(productName)
                .brand(brand)
                .productPrice(productPrice)
                .description(description)
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .productUuid(productUuid)
                .build();
    }


}

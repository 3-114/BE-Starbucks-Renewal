package com.team114.starbucks.domain.product.dto.out;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.out.CreateProductResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateProductResponseDto {

    private String productName;
    private String brand;
    private Integer productPrice;
    private Integer shippingFee;
    private ProductStatus productStatus;
    private String productUuid;

    @Builder
    public CreateProductResponseDto(
            String productName,
            String brand,
            Integer productPrice,
            Integer shippingFee,
            ProductStatus productStatus,
            String productUuid
    ) {
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
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
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .productUuid(productUuid)
                .build();
    }


}

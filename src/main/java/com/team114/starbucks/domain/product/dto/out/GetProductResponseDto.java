package com.team114.starbucks.domain.product.dto.out;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.out.GetProductResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Getter
public class GetProductResponseDto {


    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private Integer shippingFee;
    private ProductStatus productStatus;

    @Builder
    public GetProductResponseDto(
            String productUuid,
            String productName,
            String brand,
            Integer productPrice,
            Integer shippingFee,
            ProductStatus productStatus
    ) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
    }

    // dto <- entity 정적 팩토리 메서드
    public static GetProductResponseDto from(Product product) {

        return GetProductResponseDto.builder()
                .productUuid(product.getProductUuid())
                .productName(product.getProductName())
                .brand(product.getBrand())
                .productPrice(product.getProductPrice())
                .shippingFee(product.getShippingFee())
                .productStatus(product.getProductStatus())
                .build();
    }

    // dto -> vo
    public GetProductResponseVo toVo() {
        return GetProductResponseVo.builder()
                .productUuid(productUuid)
                .productName(productName)
                .brand(brand)
                .productPrice(productPrice)
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .build();
    }

}

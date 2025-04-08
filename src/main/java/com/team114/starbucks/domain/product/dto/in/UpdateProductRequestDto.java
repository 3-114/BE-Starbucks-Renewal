package com.team114.starbucks.domain.product.dto.in;

import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.in.UpdateProductRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateProductRequestDto {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private String description;
    private Integer shippingFee;
    private ProductStatus productStatus;

    @Builder
    public UpdateProductRequestDto(
            String productUuid, String productName, String brand, Integer productPrice, String description, Integer shippingFee, ProductStatus productStatus) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.description = description;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
    }


    // vo -> dto 변환
    public static UpdateProductRequestDto from(
            UpdateProductRequestVo vo
    ) {
        return UpdateProductRequestDto.builder()
                .productUuid(vo.getProductUuid())
                .productName(vo.getProductName())
                .brand(vo.getBrand())
                .productPrice(vo.getProductPrice())
                .description(vo.getDescription())
                .shippingFee(vo.getShippingFee())
                .productStatus(vo.getProductStatus())
                .build();
    }



}

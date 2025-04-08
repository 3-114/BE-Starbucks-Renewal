package com.team114.starbucks.domain.product.dto.out;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.out.UpdateProductResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateProductResponseDto {


    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private String description;
    private Integer shippingFee;
    private ProductStatus productStatus;

    @Builder
    public UpdateProductResponseDto(
            String productUuid, String productName, String brand, Integer productPrice, String description, Integer shippingFee, ProductStatus productStatus) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
    }

    // dto <- entity
    public static UpdateProductResponseDto from(Product product) {

        return UpdateProductResponseDto.builder()
                .productUuid(product.getProductUuid())
                .productName(product.getProductName())
                .brand(product.getBrand())
                .productPrice(product.getProductPrice())
                .shippingFee(product.getShippingFee())
                .productStatus(product.getProductStatus())
                .build();

    }

    // vo <- dto
    public UpdateProductResponseVo toVo() {
        return UpdateProductResponseVo.builder()
                .productUuid(productUuid)
                .productName(productName)
                .brand(brand)
                .productPrice(productPrice)
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .build();
    }


}

package com.team114.starbucks.domain.product.dto.out;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.out.GetProductResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductResDto {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private Integer shippingFee;
    private ProductStatus productStatus;

    @Builder
    public GetProductResDto(
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

    public static GetProductResDto from(Product product) {
        return GetProductResDto.builder()
                .productUuid(product.getProductUuid())
                .productName(product.getProductName())
                .brand(product.getBrand())
                .productPrice(product.getProductPrice())
                .shippingFee(product.getShippingFee())
                .productStatus(product.getProductStatus())
                .build();
    }

    public GetProductResVo toVo() {
        return GetProductResVo.builder()
                .productUuid(productUuid)
                .productName(productName)
                .brand(brand)
                .productPrice(productPrice)
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .build();
    }

}
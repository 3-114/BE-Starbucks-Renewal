package com.team114.starbucks.domain.product.dto.out;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.Brand;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.out.ProductGetResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductGetResDto {

    private Long id;
    private String productUuid;
    private Brand brand;
    private String productName;
    private Integer productPrice;
    private String description;
    private ProductStatus productStatus;
    private Integer shippingFee;

    @Builder
    public ProductGetResDto(
            Long id,
            String productUuid,
            Brand brand,
            String productName,
            Integer productPrice,
            String description,
            ProductStatus productStatus,
            Boolean optionFlag,
            Integer shippingFee
    ) {
        this.id = id;
        this.productUuid = productUuid;
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.productStatus = productStatus;
        this.shippingFee = shippingFee;
    }


    public static ProductGetResDto from(Product product) {
        return ProductGetResDto.builder()
                .id(product.getId())
                .productUuid(product.getProductUuid())
                .brand(product.getBrand())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .description(product.getDescription())
                .productStatus(product.getProductStatus())
                .shippingFee(product.getShippingFee())
                .build();
    }


    public ProductGetResVo toVo() {
        return ProductGetResVo.builder()
                .id(id)
                .productUuid(productUuid)
                .brand(brand)
                .productName(productName)
                .productPrice(productPrice)
                .description(description)
                .productStatus(productStatus)
                .shippingFee(shippingFee)
                .build();
    }





}

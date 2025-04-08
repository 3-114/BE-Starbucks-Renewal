package com.team114.starbucks.domain.product.dto.in;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.Brand;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.in.CreateProductRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateProductRequestDto {

    private String productName;
    private Brand brand;
    private Integer productPrice;
    private String description;
    private Integer shippingFee;
    private ProductStatus productStatus;


    @Builder
    public CreateProductRequestDto(
            String productName,
            Brand brand,
            Integer productPrice,
            String description,
            Integer shippingFee,
            ProductStatus productStatus
    ) {
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.description = description;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
    }

    //vo -> dto
    public static CreateProductRequestDto from(
            CreateProductRequestVo vo
    ) {
        return CreateProductRequestDto.builder()
                .productName(vo.getProductName())
                .brand(vo.getBrand())
                .productPrice(vo.getProductPrice())
                .description(vo.getDescription())
                .shippingFee(vo.getShippingFee())
                .productStatus(vo.getProductStatus())
                .build();
    }

    // dto -> entity
    public Product toEntity(String productUuid) {

        return Product.builder()
                .productUuid(productUuid)
                .productName(productName)
                .brand(brand)
                .productPrice(productPrice)
                .description(description)
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .build();
    }




}

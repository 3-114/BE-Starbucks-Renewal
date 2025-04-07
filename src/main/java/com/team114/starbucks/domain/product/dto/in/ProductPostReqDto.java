package com.team114.starbucks.domain.product.dto.in;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.Brand;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.in.ProductPostReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductPostReqDto {

    private Long id;
    private String productUuid;
    private Brand brand;
    private String productName;
    private Integer productPrice;
    private String description;
    private ProductStatus productStatus;
    private Integer shippingFee;

    @Builder
    public ProductPostReqDto(
            Long id,
            String productUuid,
            Brand brand,
            String productName,
            Integer productPrice,
            String description,
            ProductStatus productStatus,
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

    public static ProductPostReqDto from(ProductPostReqVo productPostReqVo) {
        return ProductPostReqDto.builder()
                .id(productPostReqVo.getId())
                .productUuid(productPostReqVo.getProductUuid())
                .brand(productPostReqVo.getBrand())
                .productName(productPostReqVo.getProductName())
                .productPrice(productPostReqVo.getProductPrice())
                .description(productPostReqVo.getDescription())
                .productStatus(productPostReqVo.getProductStatus())
                .shippingFee(productPostReqVo.getShippingFee())
                .build();

    }

    public Product toEntity() {
        return Product.builder()
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

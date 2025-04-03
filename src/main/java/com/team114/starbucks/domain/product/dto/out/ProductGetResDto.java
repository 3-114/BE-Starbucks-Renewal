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
    private String uuid;
    private Brand brand;
    private String name;
    private Integer price;
    private String description;
    private ProductStatus productStatus;
    private Boolean optionFlag; //?
    private Integer shippingFee;

    @Builder
    public ProductGetResDto(
            Long id,
            String uuid,
            Brand brand,
            String name,
            Integer price,
            String description,
            ProductStatus productStatus,
            Boolean optionFlag,
            Integer shippingFee
    ) {
        this.id = id;
        this.uuid = uuid;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productStatus = productStatus;
        this.optionFlag = optionFlag;
        this.shippingFee = shippingFee;
    }


    public static ProductGetResDto from(Product product) {
        return ProductGetResDto.builder()
                .id(product.getId())
                .uuid(product.getUuid())
                .brand(product.getBrand())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .productStatus(product.getProductStatus())
                .optionFlag(product.getOptionFlag())
                .shippingFee(product.getShippingFee())
                .build();
    }


    public ProductGetResVo toVo() {
        return ProductGetResVo.builder()
                .id(id)
                .uuid(uuid)
                .brand(brand)
                .name(name)
                .price(price)
                .description(description)
                .productStatus(productStatus)
                .optionFlag(optionFlag)
                .shippingFee(shippingFee)
                .build();
    }





}

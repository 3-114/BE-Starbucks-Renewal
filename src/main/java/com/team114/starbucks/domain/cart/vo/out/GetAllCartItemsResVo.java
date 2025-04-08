package com.team114.starbucks.domain.cart.vo.out;

import com.team114.starbucks.domain.product.enums.Brand;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetAllCartItemsResVo {

    private Brand brand;            // 상품 - 브랜드
    private String productName;     // 상품 - 상품명
    private Integer productPrice;   // 상품 - 상품 가격
    private String color;            // 옵션 - 컬러
    private String size;              // 옵션 - 사이즈
    private Long optionPrice;    // 옵션 - 옵션 가격
    private Integer discountRate;   // 옵션 - 할인율
    private Long quantity;          // 장바구니 - 수량
    private Boolean selected;       // 장바구니 - 선택 여부
    private Boolean valid;          // 장바구니 - 유효 여부

    @Builder
    public GetAllCartItemsResVo(
            Brand brand,
            String productName,
            Integer productPrice,
            String color,
            String size,
            Long optionPrice,
            Integer discountRate,
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.color = color;
        this.size = size;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }
}

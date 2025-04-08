package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetCartItemResVo;
import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetCartItemResDto {

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
    public GetCartItemResDto(
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

    public static GetCartItemResDto of(Cart cart, Product product, Option option) {

        return GetCartItemResDto.builder()
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .color(option.getColor().getColorName())
                .size(option.getSize().getSizeName())
                .optionPrice(option.getOptionPrice())
                .discountRate(option.getDiscountRate())
                .quantity(cart.getQuantity())
                .selected(cart.getSelected())
                .valid(cart.getValid())
                .build();
    }

    public GetCartItemResVo toVo() {

        return GetCartItemResVo.builder()
                .productName(productName)
                .productPrice(productPrice)
                .color(color)
                .size(size)
                .optionPrice(optionPrice)
                .discountRate(discountRate)
                .quantity(quantity)
                .selected(selected)
                .valid(valid)
                .build();
    }
}

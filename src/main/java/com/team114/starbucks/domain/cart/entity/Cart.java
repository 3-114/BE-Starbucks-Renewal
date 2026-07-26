package com.team114.starbucks.domain.cart.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.cart.enums.CartType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Cart extends BaseEntity {

    // 장바구니 항목 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 장바구니 항목 UUID
    private String cartUuid;

    // 멤버 UUID
    private String memberUuid;

    // 옵션 ID
    private Long optionId;

    // 상품 UUID
    private String productUuid;

    // 수량
    private Long quantity;

    // 선택 여부
    private Boolean selected;

    // 유효 여부
    private Boolean valid;

    // 장바구니 유형
    @Enumerated(EnumType.STRING)
    private CartType cartType;

    @Builder
    public Cart(
            Long id,
            String cartUuid,
            String memberUuid,
            Long optionId,
            String productUuid,
            Long quantity,
            Boolean selected,
            Boolean valid,
            CartType cartType
    ) {
        this.id = id;
        this.cartUuid = cartUuid;
        this.memberUuid = memberUuid;
        this.optionId = optionId;
        this.productUuid = productUuid;
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
        this.cartType = cartType;
    }

}
package com.team114.starbucks.domain.cart.entity;

import com.team114.starbucks.common.entity.BaseEntity;
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

    @Builder
    public Cart(
            Long id,
            String memberUuid,
            Long optionId,
            String productUuid,
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.id = id;
        this.memberUuid = memberUuid;
        this.optionId = optionId;
        this.productUuid = productUuid;
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }
}

package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetAllCartItemsResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllCartItemsResDto {

    private Long quantity;
    private Boolean selected;
    private Boolean valid;

    @Builder
    public GetAllCartItemsResDto(
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }

    public static GetAllCartItemsResDto from(Cart cart) {
        return GetAllCartItemsResDto.builder()
                .quantity(cart.getQuantity())
                .selected(cart.getSelected())
                .valid(cart.getValid())
                .build();
    }

    public static GetAllCartItemsResVo toVo(GetAllCartItemsResDto getAllCartItemsResDto) {
        return GetAllCartItemsResVo.builder()
                .quantity(getAllCartItemsResDto.getQuantity())
                .selected(getAllCartItemsResDto.getSelected())
                .valid(getAllCartItemsResDto.getValid())
                .build();
    }
}

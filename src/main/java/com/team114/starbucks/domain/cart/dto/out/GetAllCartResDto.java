package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetAllCartResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllCartResDto {

    private Long quantity;
    private Boolean selected;
    private Boolean valid;

    @Builder
    public GetAllCartResDto(
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }

    public static GetAllCartResDto from(Cart cart) {
        return GetAllCartResDto.builder()
                .quantity(cart.getQuantity())
                .selected(cart.getSelected())
                .valid(cart.getValid())
                .build();
    }

    public static GetAllCartResVo toVo(GetAllCartResDto getAllCartResDto) {
        return GetAllCartResVo.builder()
                .quantity(getAllCartResDto.getQuantity())
                .selected(getAllCartResDto.getSelected())
                .valid(getAllCartResDto.getValid())
                .build();
    }

}
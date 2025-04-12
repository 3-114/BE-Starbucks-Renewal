package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.CartUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.dto.out.GetCartItemResDto;
import com.team114.starbucks.domain.cart.dto.out.GetItemSelectResDto;
import com.team114.starbucks.domain.cart.dto.out.GetProductUuidResDto;

import java.util.List;

public interface CartService {

    void addCartItem(AddCartItemReqDto addCartItemReqDto);

    List<GetAllCartItemsResDto> findAllCartItems(String memberUuid);

    void updateCartItem(UpdateCartItemReqDto updateCartItemReqDto);

    void deleteCartItem(CartUuidReqDto cartUuidReqDto);

    GetCartItemResDto getCartItem(CartUuidReqDto cartUuidReqDto);

    GetItemSelectResDto getItemSelect(String memberUuid, String cartUuid);

    List<GetProductUuidResDto> getProductUuidList(String memberUuid, String cartType);

    void decreaseCartQuantity(CartUuidReqDto cartUuidReqDto);
}

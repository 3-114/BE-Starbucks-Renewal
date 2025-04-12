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

    Void updateCartItem(String memberUuid, String cartUuid, UpdateCartItemReqDto updateCartItemReqDto);

    Void deleteCartItem(String memberUuid, String cartUuid);

    GetCartItemResDto getCartItem(String memberUuid, String cartUuid);

    GetItemSelectResDto getItemSelect(String memberUuid, String cartUuid);

    List<GetProductUuidResDto> getProductUuidList(String memberUuid, String cartType);

    void decreaseCartQuantity(CartUuidReqDto cartUuidReqDto);

    void increaseCartQuantity(CartUuidReqDto cartUuidReqDto);
}

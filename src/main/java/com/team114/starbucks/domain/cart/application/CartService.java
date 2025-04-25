package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.domain.cart.dto.in.*;
import com.team114.starbucks.domain.cart.dto.out.*;
import com.team114.starbucks.domain.cart.vo.out.GetMyCartTypeReqDto;

import java.util.List;

public interface CartService {

    void addCartItem(CreateCartReqDto createCartReqDto);

    List<GetAllCartResDto> findAllCartItems(String memberUuid);

    void updateCartItem(UpdateCartReqDto updateCartReqDto);

    void deleteCartItem(GetMyCartUuidReqDto getMyCartUuidReqDto);

    GetCartAndProductResDto getCartItem(GetMyCartUuidReqDto getMyCartUuidReqDto);

    GetCartSelectResDto getItemSelect(GetMyCartUuidReqDto getMyCartUuidReqDto);

    List<GetProductUuidResDto> getProductUuidList(GetMyCartTypeReqDto getMyCartTypeReqDto);

    void decreaseCartQuantity(GetMyCartUuidReqDto getMyCartUuidReqDto);

    void increaseCartQuantity(GetMyCartUuidReqDto getMyCartUuidReqDto);

    GetTotalCartCountResDto countTotalCart(GetMyCartTypeReqDto getMyCartTypeReqDto);

    List<GetQuantityAndSelectedDto> getCartByProductUuid(ProductUuidReqDto productUuidReqDto);

    List<GetAllMyCartUuidDto> getMyCartUuids(com.team114.starbucks.domain.cart.dto.in.GetMyCartTypeReqDto getMyCartTypeReqDto);

    void toggleCartSelection(GetMyCartUuidReqDto getMyCartUuidReqDto);

    List<GetAllMyCartUuidDto> toggleAllCartSelection(String memberUuid);

    void changeCartQuantity(GetMyCartQuantityReqDto getMyCartQuantityReqDto);

    void deleteAllCartItems(com.team114.starbucks.domain.cart.dto.in.GetMyCartTypeReqDto getMyCartTypeReqDto);

}

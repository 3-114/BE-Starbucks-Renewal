package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.CartUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.dto.out.GetCartItemResDto;
import com.team114.starbucks.domain.cart.dto.out.GetItemSelectResDto;
import com.team114.starbucks.domain.cart.dto.out.GetProductUuidResDto;
import com.team114.starbucks.domain.cart.enums.CartType;
import com.team114.starbucks.domain.cart.infrastructure.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Transactional
    @Override
    public void addCartItem(AddCartItemReqDto addCartItemReqDto) {
        cartRepository.save(addCartItemReqDto.toEntity(UUID.randomUUID().toString()));
    }

    @Override
    public List<GetAllCartItemsResDto> findAllCartItems(String memberUuid) {
        return cartRepository.findCartItems(memberUuid);
    }

    @Transactional
    @Override
    public void updateCartItem(UpdateCartItemReqDto updateCartItemReqDto) {
        cartRepository.save(updateCartItemReqDto.toEntity(cartRepository.findByCartUuid(updateCartItemReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND))));
    }

    @Transactional
    @Override
    public void deleteCartItem(CartUuidReqDto cartUuidReqDto) {
        cartRepository.deleteByCartUuid(cartUuidReqDto.getCartUuid());
    }

    @Override
    public GetCartItemResDto getCartItem(CartUuidReqDto cartUuidReqDto) {
        return GetCartItemResDto.from(cartRepository.findByCartUuid(cartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)));
    }

    @Override
    public GetItemSelectResDto getItemSelect(CartUuidReqDto cartUuidReqDto) {
        return GetItemSelectResDto.from(cartRepository.findByCartUuid(cartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)));
    }

    @Override
    public List<GetProductUuidResDto> getProductUuidList(String memberUuid, String cartType) {
        return cartRepository.findByMemberUuid(memberUuid)
                .stream()
                .filter(cart -> cart.getCartType().equals(
                        CartType.valueOf(cartType.toUpperCase())
                ))
                .map(GetProductUuidResDto::from)
                .toList();
    }

    @Transactional
    @Override
    public void decreaseCartQuantity(CartUuidReqDto cartUuidReqDto) {
        cartRepository.save(cartUuidReqDto.decreaseQuantity(cartRepository.findByCartUuid(cartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND))));
    }
}

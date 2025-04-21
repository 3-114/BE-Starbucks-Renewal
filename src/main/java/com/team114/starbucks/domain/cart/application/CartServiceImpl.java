package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.CartUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.ProductUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.*;
import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.enums.CartType;
import com.team114.starbucks.domain.cart.infrastructure.CartRepository;
import com.team114.starbucks.domain.cart.vo.out.CartTypeReqDto;
import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.out.GetProductPreviewResponseDto;
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
    private final ProductService productService;

    @Transactional
    @Override
    public void addCartItem(AddCartItemReqDto addCartItemReqDto) {
        cartRepository.save(addCartItemReqDto.toEntity(UUID.randomUUID().toString()));
    }

    @Override
    public List<GetAllCartItemsResDto> findAllCartItems(String memberUuid) {
        return cartRepository.findByMemberUuidOrderBySelectedDesc(memberUuid)
                .stream().map(GetAllCartItemsResDto::from).toList();
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
    public CartAndProductResDto getCartItem(CartUuidReqDto cartUuidReqDto) {
        Cart cart = cartRepository.findByCartUuid(cartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));
        GetProductPreviewResponseDto getProductPreviewResponseDto = productService.getProductPreview(cart.getProductUuid());
        return CartAndProductResDto.of(cart, getProductPreviewResponseDto);
    }

    @Override
    public GetItemSelectResDto getItemSelect(CartUuidReqDto cartUuidReqDto) {
        return GetItemSelectResDto.from(cartRepository.findByCartUuid(cartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)));
    }

    @Override
    public List<GetProductUuidResDto> getProductUuidList(CartTypeReqDto cartTypeReqDto) {
        return cartRepository.findByMemberUuidOrderBySelectedDesc(cartTypeReqDto.getMemberUuid())
                .stream()
                .filter(cart -> cart.getCartType().equals(
                        CartType.valueOf(cartTypeReqDto.getCartType().toUpperCase())
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

    @Transactional
    @Override
    public void increaseCartQuantity(CartUuidReqDto cartUuidReqDto) {
        cartRepository.save(cartUuidReqDto.increaseQuantity(cartRepository.findByCartUuid(cartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND))));
    }

    @Override
    public CountTotalCartResDto countTotalCart(CartTypeReqDto cartTypeReqDto) {
        return CountTotalCartResDto.from(
                cartRepository.countByMemberUuidAndCartType(
                        cartTypeReqDto.getMemberUuid(),
                        CartType.valueOf(cartTypeReqDto.getCartType().toUpperCase())
                )
        );
    }

    @Override
    public List<GetQuantityAndSelectedDto> getCartByProductUuid(ProductUuidReqDto productUuidReqDto) {
        return cartRepository.findByMemberUuidAndProductUuid(
                        productUuidReqDto.getMemberUuid(),
                        productUuidReqDto.getProductUuid())
                .stream().map(GetQuantityAndSelectedDto::from).toList();
    }

    @Override
    public List<MyCartUuidDto> getMyCartUuids(String memberUuid) {
        return cartRepository.findByMemberUuidOrderBySelectedDesc(memberUuid)
                .stream().map(MyCartUuidDto::from).toList();
    }

    @Transactional
    @Override
    public void toggleCartSelection(CartUuidReqDto cartUuidReqDto) {
        cartRepository.save(cartUuidReqDto.toggleSelection(
                cartRepository.findByCartUuid(cartUuidReqDto.getCartUuid()).orElseThrow(
                        () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
                )
        ));
    }

    @Transactional
    @Override
    public void toggleAllCartSelection(String memberUuid) {
        List<Cart> carts = cartRepository.findByMemberUuidOrderBySelectedDesc(memberUuid);

        boolean newSelected = carts.stream().anyMatch(cart -> !cart.getSelected());

        cartRepository.saveAll(carts.stream()
                .map(cart -> Cart.builder()
                        .id(cart.getId())
                        .cartUuid(cart.getCartUuid())
                        .memberUuid(cart.getMemberUuid())
                        .optionId(cart.getOptionId())
                        .productUuid(cart.getProductUuid())
                        .quantity(cart.getQuantity())
                        .selected(newSelected)
                        .valid(cart.getValid())
                        .cartType(cart.getCartType())
                        .build())
                .toList());
    }
}

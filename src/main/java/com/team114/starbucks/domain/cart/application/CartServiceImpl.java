package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.cart.dto.in.*;
import com.team114.starbucks.domain.cart.dto.out.*;
import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.enums.CartType;
import com.team114.starbucks.domain.cart.infrastructure.CartRepository;
import com.team114.starbucks.domain.cart.vo.out.GetMyCartTypeReqDto;
import com.team114.starbucks.domain.option.application.OptionService;
import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.out.GetProductPreviewResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final OptionService optionService;

    @Transactional
    @Override
    public void addCartItem(CreateCartReqDto createCartReqDto) {
        cartRepository.save(
                createCartReqDto.toEntity(
                        optionService.findAnyOptionByProductUuid(createCartReqDto.getProductUuid())
                )
        );
    }

    @Override
    public List<GetAllCartResDto> findAllCartItems(String memberUuid) {
        return cartRepository.findByMemberUuid(memberUuid)
                .stream().map(GetAllCartResDto::from).toList();
    }

    @Transactional
    @Override
    public void updateCartItem(UpdateCartReqDto updateCartReqDto) {
        cartRepository.save(updateCartReqDto.toEntity(cartRepository.findByCartUuid(updateCartReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND))));
    }

    @Transactional
    @Override
    public void deleteCartItem(GetMyCartUuidReqDto getMyCartUuidReqDto) {
        cartRepository.deleteByCartUuid(getMyCartUuidReqDto.getCartUuid());
    }

    @Override
    public GetCartAndProductResDto getCartItem(GetMyCartUuidReqDto getMyCartUuidReqDto) {
        Cart cart = cartRepository.findByCartUuid(getMyCartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));
        GetProductPreviewResDto getProductPreviewResDto = productService.getProductPreview(cart.getProductUuid());
        return GetCartAndProductResDto.of(cart, getProductPreviewResDto);
    }

    @Override
    public GetCartSelectResDto getItemSelect(GetMyCartUuidReqDto getMyCartUuidReqDto) {
        return GetCartSelectResDto.from(cartRepository.findByCartUuid(getMyCartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)));
    }

    @Override
    public List<GetProductUuidResDto> getProductUuidList(GetMyCartTypeReqDto getMyCartTypeReqDto) {
        return cartRepository.findByMemberUuid(getMyCartTypeReqDto.getMemberUuid())
                .stream()
                .filter(cart -> cart.getCartType().equals(
                        CartType.valueOf(getMyCartTypeReqDto.getCartType().toUpperCase())
                ))
                .map(GetProductUuidResDto::from)
                .toList();
    }

    @Transactional
    @Override
    public void decreaseCartQuantity(GetMyCartUuidReqDto getMyCartUuidReqDto) {
        cartRepository.save(getMyCartUuidReqDto.decreaseQuantity(cartRepository.findByCartUuid(getMyCartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND))));
    }

    @Transactional
    @Override
    public void increaseCartQuantity(GetMyCartUuidReqDto getMyCartUuidReqDto) {
        cartRepository.save(getMyCartUuidReqDto.increaseQuantity(cartRepository.findByCartUuid(getMyCartUuidReqDto.getCartUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND))));
    }

    @Override
    public GetTotalCartCountResDto countTotalCart(GetMyCartTypeReqDto getMyCartTypeReqDto) {
        return GetTotalCartCountResDto.from(
                cartRepository.countByMemberUuidAndCartType(
                        getMyCartTypeReqDto.getMemberUuid(),
                        CartType.valueOf(getMyCartTypeReqDto.getCartType().toUpperCase())
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
    public List<GetAllMyCartUuidDto> getMyCartUuids(com.team114.starbucks.domain.cart.dto.in.GetMyCartTypeReqDto getMyCartTypeReqDto) {
        return getMyCartTypeReqDto.getCartType() == null
                ? cartRepository.findByMemberUuid(getMyCartTypeReqDto.getMemberUuid())
                .stream().map(GetAllMyCartUuidDto::from).toList()
                : cartRepository.findByMemberUuid(
                        getMyCartTypeReqDto.getMemberUuid())
                .stream()
                .filter(cart -> cart.getCartType().equals(
                        CartType.valueOf(getMyCartTypeReqDto.getCartType().toUpperCase())))
                .map(GetAllMyCartUuidDto::from).toList();
    }

    @Transactional
    @Override
    public void toggleCartSelection(GetMyCartUuidReqDto getMyCartUuidReqDto) {
        cartRepository.save(getMyCartUuidReqDto.toggleSelection(
                cartRepository.findByCartUuid(getMyCartUuidReqDto.getCartUuid()).orElseThrow(
                        () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
                )
        ));
    }

    @Transactional
    @Override
    public List<GetAllMyCartUuidDto> toggleAllCartSelection(String memberUuid) {
        List<Cart> carts = cartRepository.findByMemberUuid(memberUuid);

        boolean newSelected = carts.stream().anyMatch(cart -> !cart.getSelected());

        List<GetAllMyCartUuidDto> results = carts.stream()
                .filter(cart -> !newSelected || !cart.getSelected())
                .map(GetAllMyCartUuidDto::from)
                .toList();

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

        return results;
    }

    @Transactional
    @Override
    public void changeCartQuantity(GetMyCartQuantityReqDto getMyCartQuantityReqDto) {
        cartRepository.save(getMyCartQuantityReqDto.changeQuantity(
                cartRepository.findByCartUuid(getMyCartQuantityReqDto.getCartUuid())
                        .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND))));
    }

    @Transactional
    @Override
    public void deleteAllCartItems(com.team114.starbucks.domain.cart.dto.in.GetMyCartTypeReqDto getMyCartTypeReqDto) {
        cartRepository.deleteAllByMemberUuidAndCartType(
                getMyCartTypeReqDto.getMemberUuid(),
                CartType.valueOf(getMyCartTypeReqDto.getCartType().toUpperCase()));
    }

}
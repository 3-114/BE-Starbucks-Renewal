package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.dto.out.GetCartItemResDto;
import com.team114.starbucks.domain.cart.dto.out.GetItemSelectResDto;
import com.team114.starbucks.domain.cart.dto.out.GetProductUuidResDto;
import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.enums.CartType;
import com.team114.starbucks.domain.cart.infrastructure.CartRepository;
import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.infrastructure.OptionRepository;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
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
    private final OptionRepository optionRepository;
    private final ProductRepository productRepository;

    @Transactional
    @Override
    public void addCartItem(AddCartItemReqDto addCartItemReqDto) {
        cartRepository.save(addCartItemReqDto.toEntity(UUID.randomUUID().toString()));
    }

    @Override
    public List<GetAllCartItemsResDto> findAllCartItems(String memberUuid) {

        return cartRepository.findCartItems(memberUuid);

    }

    /**
     * 3. 장바구니 항목 정보 변경
     * @param memberUuid
     * @param cartUuid
     * @param updateCartItemReqDto
     * @return
     */
    @Transactional
    @Override
    public Void updateCartItem(String memberUuid, String cartUuid, UpdateCartItemReqDto updateCartItemReqDto) {

        // cartUuid -> cart 조회
        Cart cart = cartRepository.findByCartUuid(cartUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        // newCart 객체 생성
        Cart newCart = Cart.builder()
                .id(cart.getId())
                .memberUuid(cart.getMemberUuid())
                .optionId(cart.getOptionId())
                .productUuid(cart.getProductUuid())
                .quantity(updateCartItemReqDto.getQuantity() == null ? cart.getQuantity() : updateCartItemReqDto.getQuantity())
                .selected(updateCartItemReqDto.getSelected() == null ? cart.getSelected() : updateCartItemReqDto.getSelected())
                .build();

        // save 호출
        cartRepository.save(newCart);

        return null;
    }

    @Transactional
    @Override
    public Void deleteCartItem(String memberUuid, String cartUuid) {

        cartRepository.deleteByCartUuid(cartUuid);

        return null;
    }

    @Override
    public GetCartItemResDto getCartItem(String memberUuid, String cartUuid) {

        Cart cart = cartRepository.findByCartUuid(cartUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        Product product = productRepository.findByProductUuid(cart.getProductUuid()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        Option option = optionRepository.findByOptionId(cart.getOptionId()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        return GetCartItemResDto.of(cart, product, option);
    }

    @Override
    public GetItemSelectResDto getItemSelect(String memberUuid, String cartUuid) {

        return GetItemSelectResDto.from(cartRepository.findByCartUuid(cartUuid)
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
}

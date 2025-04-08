package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.infrastructure.CartRepository;
import com.team114.starbucks.domain.cart.vo.in.UpdateCartItemReqVo;
import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.infrastructure.OptionRepository;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final OptionRepository optionRepository;
    private final ProductRepository productRepository;

    /**
     * /api/v1/cart
     * 1. 장바구니 항목 추가
     * 2. 장바구니 항목 전체 조회
     * 3. 장바구니 항목 정보 변경
     * 4. 장바구니 항목 삭제
     */

    /**
     * 1. 장바구니 항목 추가
     * @param memberUuid
     * @param productUuid
     * @param optionId
     * @param addCartItemReqDto
     * @return
     */
    @Transactional
    @Override
    public Void addCartItem(
            String memberUuid, String productUuid, Long optionId, AddCartItemReqDto addCartItemReqDto
    ) {
        // product UUID 로 product 조회
        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        // 상품 판매 상태 조회
        final ProductStatus productStatus = product.getProductStatus();

        Boolean validityOfProductStatus;

        /**
         *   [1] 상품 상태에 대한 유효성 검사 - validityOfProductStatus
         *   case1 : 상품 판매 상태가 판매 중이라면, validityOfProductStatus 는 true
         *   case2 : 그 외는 validityOfProductStatus 는 false
         */
        if(productStatus == ProductStatus.For_Sale) {
            validityOfProductStatus = true;
        } else {
            validityOfProductStatus = false;
        }

        // Option id 로 Option 조회
        Option option = optionRepository.findByOptionId(optionId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        // 옵션 재고 값 조회
        final Integer optionStock = option.getStock();

        Boolean validityOfOptionStock;

        /**
         *   [2] 옵션에 대한 유효성 검사 - validityOfOptionStock
         *   case1 : 옵션 재고가 0 이라면 validityOfOptionStock : false
         *   case2 : 옵션 재고가 1 이상이라면 validityOfOptionStock : true
         *   case3 : 그 외에는 예외 처리
         */
        if(optionStock >= 1) {
            validityOfOptionStock = true;
        } else if(optionStock == 0) {
            validityOfOptionStock = false;
        } else {
            throw new BaseException(BaseResponseStatus.NO_EXIST_VALUE);
        }

        Boolean valid;

        if(validityOfProductStatus && validityOfOptionStock) {
            valid = true;
        } else {
            valid = false;
        }

        // Cart 객체 생성
        Cart cart = Cart.builder()
                .memberUuid(memberUuid)
                .optionId(optionId)
                .productUuid(productUuid)
                .quantity(addCartItemReqDto.getQuantity())
                .selected(addCartItemReqDto.getSelected())
                .valid(valid)
                .build();

        // save 호출
        cartRepository.save(cart);

        return null;
    }

    /**
     * 2. 장바구니 항목 전체 조회
     * @param memberUuid
     * @return
     */
    @Override
    public List<GetAllCartItemsResDto> findAllCartItems(String memberUuid) {

        return cartRepository.findCartItems(memberUuid);

    }

    /**
     * 3. 장바구니 항목 정보 변경
     * @param memberUuid
     * @param cartId
     * @param updateCartItemReqDto
     * @return
     */
    @Transactional
    @Override
    public Void updateCartItem(String memberUuid, Long cartId, UpdateCartItemReqDto updateCartItemReqDto) {

        // cartId -> cart 조회
        Cart cart = cartRepository.findById(cartId).orElseThrow(
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

    /**
     * 4. 장바구니 항목 삭제
     * @param memberUuid
     * @param cartId
     * @return
     */
    @Transactional
    @Override
    public Void deleteCartItem(String memberUuid, Long cartId) {

        cartRepository.deleteById(cartId);

        return null;
    }
}

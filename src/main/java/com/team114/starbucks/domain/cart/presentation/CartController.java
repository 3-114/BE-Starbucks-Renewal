package com.team114.starbucks.domain.cart.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.cart.application.CartService;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.vo.in.AddCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.out.GetAllCartItemsResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    /**
     * /api/v1/cart
     * 1. 장바구니 항목 추가
     * 2. 장바구니 항목 전체 조회
     * 3. 장바구니 항목 수량 추가
     * 4. 장바구니 항목 수량 감소
     * 5. 장바구니 항목 삭제
     */

    /**
     * 1. 장바구니 항목 추가
     * @param memberUuid
     * @param productUuid
     * @param addCartItemReqVo
     * @return
     */
    @PostMapping
    public BaseResponseEntity<Void> addCartItem(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @RequestHeader("X-Product-UUID") String productUuid,          // product UUID
            @RequestParam(value = "optionId") Long optionId,              // option ID
            @RequestBody AddCartItemReqVo addCartItemReqVo                // 수량, 선택 여부
    ) {
        cartService.addCartItem(
                memberUuid,
                productUuid,
                optionId,
                AddCartItemReqDto.from(addCartItemReqVo)
        );
        return new BaseResponseEntity<>("장바구니에 추가되었습니다.", null);
    }

    @GetMapping
    public Page<GetAllCartItemsResVo> getAllCartItems(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @PageableDefault(
                    page = 0,                              // 기본 페이지 번호 : 0부터 시작, 첫 페이지
                    size = 10,                             // 한 페이지당 항목 수 : 기본 10개씩 조회
                    sort = "productName",                  // 정렬 기준 컬럼 : 상품명
                    direction = Sort.Direction.DESC        // 정렬 방향 : 최신순 (내림차순)
            ) Pageable pageable
    ) {
        cartService.getAllCartItems(memberUuid, pageable);
    }
}

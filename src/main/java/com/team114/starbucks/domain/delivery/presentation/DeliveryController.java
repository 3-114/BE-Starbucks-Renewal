package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.delivery.dto.in.CartDeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryCreateRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliverySelectedRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryUpdateRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.application.DeliveryService;
import com.team114.starbucks.domain.delivery.dto.out.GetCartDeliveryResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliveryUuidResponseDto;
import com.team114.starbucks.domain.delivery.vo.in.CartDeliveryRequestVo;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryCreateRequestVo;
import com.team114.starbucks.domain.delivery.vo.in.DeliverySelectedRequestVo;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryUpdateRequestVo;
import com.team114.starbucks.domain.delivery.vo.out.DeliveryResponseVo;
import com.team114.starbucks.domain.delivery.vo.out.DeliverySelectedResponseVo;
import com.team114.starbucks.domain.delivery.vo.out.GetCartDeliveryResponseVo;
import com.team114.starbucks.domain.delivery.vo.out.GetDeliveryUuidResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    // 1. 배송지 생성
    @Operation(summary = "배송지 등록", description = "배송지를 등록합니다.", tags = {"delivery"})
    @PostMapping
    public BaseResponseEntity<DeliveryResponseVo> createDelivery(
            @RequestBody DeliveryCreateRequestVo deliveryCreateRequestVo,
            Authentication authentication
    ) {

        DeliveryResponseVo result = deliveryService.saveDelivery(
                DeliveryCreateRequestDto.from(deliveryCreateRequestVo, authentication.getName())).toVo();
        return new BaseResponseEntity<>("배송지가 등록되었습니다.", result);
    }

    // 2. 배송지 수정
    @Operation(summary = "배송지 수정", description = "기존 배송지를 비활성화하고 새 배송지를 생성합니다.", tags = {"delivery"})
    @PutMapping("/{deliveryUuid}")
    public BaseResponseEntity<DeliveryResponseVo> updateDelivery(
            @PathVariable String deliveryUuid,
            Authentication authentication,
            @RequestBody DeliveryUpdateRequestVo deliveryUpdateRequestVo) {

        deliveryService.updateDelivery(DeliveryUpdateRequestDto.from(deliveryUpdateRequestVo, authentication.getName(), deliveryUuid));

        return new BaseResponseEntity<>("배송지가 수정되었습니다.");
    }

    // 3. 배송지 삭제
    @Operation(summary = "배송지 삭제", description = "배송지를 삭제합니다.", tags = {"delivery"})
    @DeleteMapping("/{deliveryUuid}")
    public BaseResponseEntity<Void> deleteDelivery(
            @PathVariable String deliveryUuid
    ) {
        deliveryService.deleteDelivery(deliveryUuid);
        return new BaseResponseEntity<>("배송지가 삭제되었습니다.", null);
    }

    // 4. 마이페이지 배송지 목록 조회
    @Operation(summary = "배송지 목록 조회", description = "회원의 전체 배송지를 조회합니다.", tags = {"delivery"})
    @GetMapping("/all")
    public BaseResponseEntity<List<DeliveryResponseVo>> getAllDeliveries(
            Authentication authentication) {

        List<DeliveryResponseVo> result = deliveryService.getDeliveriesByMemberUuid(authentication.getName())
                .stream().map(DeliveryResponseDto::toVo).toList();

        return new BaseResponseEntity<>("배송지 목록 조회 성공", result);
    }

    // 5. 장바구니에서 배송지 UUID 리스트 조회
    @Operation(summary = "배송지 UUID 목록 조회", description = "회원의 배송지 UUID 목록만 조회합니다.", tags = {"delivery"})
    @GetMapping("/cart/uuids")
    public BaseResponseEntity<List<GetDeliveryUuidResponseVo>> getCartDeliveryUuid(
            Authentication authentication
    ) {
        List<GetDeliveryUuidResponseVo> result = deliveryService.getDeliveryUuidsByMemberUuid(authentication.getName())
                .stream().map(GetDeliveryUuidResponseDto::toVo).toList();

        return new BaseResponseEntity<>("장바구니의 배송지 UUID 리스트 조회 성공", result);
    }

    // 6. 장바구니의 캐러셀에서 갱신될 배송지 단건 수정
    @Operation(summary = "장바구니 배송지 변경", description = "장바구니의 캐러셀 배송지 변경", tags = {"delivery"})
    @PutMapping("/cart/update-address")
    public BaseResponseEntity<DeliverySelectedResponseVo> updateSelectedDelivery(
            Authentication authentication,
            @RequestBody DeliverySelectedRequestVo deliverySelectedRequestVo
    ) {

        DeliverySelectedResponseVo result = deliveryService
                .updateSelectedDelivery(DeliverySelectedRequestDto.from(deliverySelectedRequestVo, authentication.getName())).toVo();

        return new BaseResponseEntity<>("선택된 배송지가 변경되었습니다.", result);
    }

    // 7. 장바구니 캐러셀 단건 조회
    @Operation(summary = "장바구니 배송지 목록 조회", description = "장바구니 배송지를 단건 조회합니다.", tags = {"delivery"})
    @GetMapping("/cart/get-address/{deliveryUuid}")
    public BaseResponseEntity<GetCartDeliveryResponseVo> getSelectedDelivery(
            Authentication authentication,
            @PathVariable String deliveryUuid
    ) {
        GetCartDeliveryResponseVo result = deliveryService
                .getCartDeliveryByUuid(CartDeliveryRequestDto.from(deliveryUuid, authentication.getName())).toVo();

        return new BaseResponseEntity<>("캐러셀 배송지 단건 조회에 성공했습니다.", result);
    }

    // 8. 배송지 단건 조회 (주문용)
    @Operation(summary = "주문용 배송지 조회", description = "장바구니에서 선택된 배송지 조회", tags = {"delivery"})
    @GetMapping("/order/selected-address")
    public BaseResponseEntity<DeliverySelectedResponseVo> getSelectedDelivery(
            Authentication authentication
    ) {
        DeliverySelectedResponseVo result = deliveryService
                .getSelectedDeliveryByMemberUuid(authentication.getName())
                .toVo();

        return new BaseResponseEntity<>("선택된 배송지 조회 성공", result);
    }
}
package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryCreateRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryUpdateRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.application.DeliveryService;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliveryUuidResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetMyDeliveriesResponseDto;
import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryCreateRequestVo;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryUpdateRequestVo;
import com.team114.starbucks.domain.delivery.vo.out.DeliveryResponseVo;
import com.team114.starbucks.domain.delivery.vo.out.GetDeliveryUuidResponseVo;
import com.team114.starbucks.domain.delivery.vo.out.GetMyDeliveriesResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @RequestHeader("Member-Uuid") String memberUuid
    ) {

        DeliveryResponseVo result = deliveryService.saveDelivery(
                DeliveryCreateRequestDto.from(deliveryCreateRequestVo, memberUuid)).toVo();
        return new BaseResponseEntity<>("배송지가 등록되었습니다.", result);
    }

    // 2. 배송지 수정
    @Operation(summary = "배송지 수정", description = "기존 배송지를 비활성화하고 새 배송지를 생성합니다.", tags = {"delivery"})
    @PutMapping("/{deliveryUuid}")
    public BaseResponseEntity<DeliveryResponseVo> updateDelivery(
            @PathVariable String deliveryUuid,
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody DeliveryUpdateRequestVo deliveryUpdateRequestVo) {

        deliveryService.updateDelivery(DeliveryUpdateRequestDto.from(deliveryUpdateRequestVo, memberUuid, deliveryUuid));

        return new BaseResponseEntity<>("배송지가 수정되었습니다.");
    }


    // 3. 마이페이지 배송지 목록 조회
    @Operation(summary = "배송지 목록 조회", description = "회원의 전체 배송지를 조회합니다.", tags = {"delivery"})
    @GetMapping("/all")
    public BaseResponseEntity<List<DeliveryResponseVo>> getAllDeliveries(
            @RequestHeader("Member-Uuid") String memberUuid ) {

        List<DeliveryResponseVo> result = deliveryService.getDeliveriesByMemberUuid(memberUuid)
                .stream().map(DeliveryResponseDto::toVo).toList();

        return new BaseResponseEntity<>("배송지 목록 조회 성공", result);
    }

    // 4. 장바구니 배송지 목록 조회
    @Operation(summary = "배송지 목록 조회", description = "회원의 전체 배송지를 조회합니다.", tags = {"delivery"})
    @GetMapping("/cart-detail")
    public BaseResponseEntity<List<GetMyDeliveriesResponseVo>> getCartDeliveries(
            @RequestHeader("Member-Uuid") String memberUuid ) {

        List<GetMyDeliveriesResponseVo> result = deliveryService.getCartDeliveriesByMemberUuid(memberUuid)
                .stream().map(GetMyDeliveriesResponseDto::toVo).toList();

        return new BaseResponseEntity<>("배송지 목록 조회 성공", result);
    }

    // 5. 장바구니에서 배송지 UUID 리스트 조회
    @Operation(summary = "배송지 UUID 목록 조회", description = "회원의 배송지 UUID 목록만 조회합니다.", tags = {"delivery"})
    @GetMapping("/cart")
    public BaseResponseEntity<List<GetDeliveryUuidResponseVo>> getCartDeliveryUuid(
            @RequestHeader("Member-Uuid") String memberUuid
    ) {
        List<GetDeliveryUuidResponseVo> result = deliveryService.getDeliveryUuidsByMemberUuid(memberUuid)
                .stream().map(GetDeliveryUuidResponseDto::toVo).toList();

        return new BaseResponseEntity<>("장바구니의 배송지 UUID 리스트 조회 성공", result);
    }

    // 배송지 삭제
    @Operation(summary = "배송지 삭제", description = "배송지를 삭제합니다.", tags = {"delivery"})
    @DeleteMapping("/{deliveryUuid}")
    public BaseResponseEntity<Void> deleteDelivery(
            @PathVariable String deliveryUuid
    ) {
        deliveryService.deleteDelivery(deliveryUuid);
        return new BaseResponseEntity<>("배송지가 삭제되었습니다.", null);
    }
}
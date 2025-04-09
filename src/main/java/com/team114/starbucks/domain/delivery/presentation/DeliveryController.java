package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryCreateRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryUpdateRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.application.DeliveryService;
import com.team114.starbucks.domain.delivery.dto.out.GetMyDeliveriesResponseDto;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryCreateRequestVo;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryUpdateRequestVo;
import com.team114.starbucks.domain.delivery.vo.out.DeliveryResponseVo;
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

    // 배송지 생성
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

    // 배송지 목록 조회
    @Operation(summary = "배송지 목록 조회", description = "회원의 전체 배송지를 조회합니다.", tags = {"delivery"})
    @GetMapping
    public BaseResponseEntity<List<GetMyDeliveriesResponseVo>> getAllDeliveries(
            @RequestHeader("Member-Uuid") String memberUuid ) {

        List<GetMyDeliveriesResponseVo> result = deliveryService.getDeliveriesByMemberUuid(memberUuid)
                .stream().map(GetMyDeliveriesResponseDto::toVo).toList();

        return new BaseResponseEntity<>("배송지 목록 조회 성공", result);
    }


    // 배송지 수정
    @Operation(summary = "배송지 수정", description = "기존 배송지를 비활성화하고 새 배송지를 생성합니다.", tags = {"delivery"})
    @PutMapping("/{deliveryUuid}")
    public BaseResponseEntity<DeliveryResponseVo> updateDelivery(
            @PathVariable String deliveryUuid,
            @RequestBody DeliveryUpdateRequestVo deliveryUpdateRequestVo,
            @RequestHeader("Member-Uuid") String memberUuid) {

        DeliveryResponseVo result = deliveryService.updateDelivery(
                deliveryUuid,
                DeliveryUpdateRequestDto.from(deliveryUpdateRequestVo),
                memberUuid
        ).toVo();

        return new BaseResponseEntity<>("배송지가 수정되었습니다.", result);
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
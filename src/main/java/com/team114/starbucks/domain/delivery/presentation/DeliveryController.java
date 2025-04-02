package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.application.DeliveryService;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryRequestVo;
import com.team114.starbucks.domain.delivery.vo.out.DeliveryResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
@RequiredArgsConstructor
@Tag(name = "배송지 API", description = "배송지 관련 CRUD API")
public class DeliveryController {

    private final DeliveryService deliveryService;

    // 배송지 생성
    @Operation(summary = "배송지 등록", description = "배송지를 등록합니다.", tags = {"delivery"})
    @PostMapping("/{memberUuid}")
    public BaseResponseEntity<DeliveryResponseVo> createDelivery(
            @RequestBody DeliveryRequestVo deliveryRequestVo,
            @PathVariable String memberUuid) {

        DeliveryResponseDto result = deliveryService.
                createDelivery(DeliveryRequestDto.from(memberUuid, deliveryRequestVo), memberUuid);
        return new BaseResponseEntity<>("배송지가 등록되었습니다.", result.toVo());
    }


    // 배송지 목록 조회
    @Operation(summary = "배송지 목록 조회", description = "회원의 전체 배송지를 조회합니다.", tags = {"delivery"})
    @GetMapping("/{memberUuid}")
    public BaseResponseEntity<List<DeliveryResponseDto>> getDeliveriesByMember(
            @PathVariable String memberUuid) {

        List<DeliveryResponseDto> result = deliveryService.getDeliveriesByMemberUuid(memberUuid);
        return new BaseResponseEntity<>("배송지 목록 조회 성공", result);
    }

    // 배송지 수정
    @Operation(summary = "배송지 수정", description = "기존 배송지를 비활성화하고 새 배송지를 생성합니다.", tags = {"delivery"})
    @PutMapping("/{memberUuid}/{deliveryUuid}")
    public BaseResponseEntity<DeliveryResponseVo> updateDelivery(
            @PathVariable String deliveryUuid,
            @PathVariable String memberUuid,
            @RequestBody DeliveryRequestVo deliveryRequestVo) {

        DeliveryResponseDto result = deliveryService.updateDelivery(
                deliveryUuid,
                DeliveryRequestDto.from(memberUuid, deliveryRequestVo), memberUuid);

        return new BaseResponseEntity<>("배송지가 수정되었습니다.", result.toVo());
    }

    // 배송지 삭제
    @Operation(summary = "배송지 삭제", description = "배송지를 삭제합니다.", tags = {"delivery"})
    @DeleteMapping("/{deliveryUuid}")
    public BaseResponseEntity<DeliveryResponseVo> deleteDelivery(
            @PathVariable String deliveryUuid) {

        DeliveryResponseDto result = deliveryService.deleteDelivery(deliveryUuid);
        return new BaseResponseEntity<>("배송지가 삭제되었습니다.", result.toVo());
    }

    // 기본 배송지 설정
    @Operation(summary = "기본 배송지 설정", description = "기존 기본 배송지를 해제하고 해당 배송지를 기본 배송지로 설정합니다.", tags = {"delivery"})
    @PutMapping("/default/{memberUuid}/{deliveryUuid}")
    public BaseResponseEntity<DeliveryResponseVo> setDefaultDelivery(
            @PathVariable String memberUuid,
            @PathVariable String deliveryUuid) {

        DeliveryResponseDto result = deliveryService.setDefaultDelivery(deliveryUuid, memberUuid);
        return new BaseResponseEntity<>("기본 배송지가 설정되었습니다.", result.toVo());
    }
}
package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.application.DeliveryService;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryCreateRequestVo;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryUpdateRequestVo;
import com.team114.starbucks.domain.delivery.vo.out.DeliveryResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deliveries")
@Tag(name = "배송지 API", description = "배송지 관련 CRUD API")
public class DeliveryController {

    private final DeliveryService deliveryService;

    // 배송지 생성
    @Operation(summary = "배송지 등록", description = "배송지를 등록합니다.", tags = {"delivery"})
    @PostMapping("")
    public BaseResponseEntity<DeliveryResponseVo> createDelivery(
            @RequestBody DeliveryCreateRequestVo createVo,
            @RequestHeader("Member-Uuid") String memberUuid) {

        DeliveryRequestDto dto = DeliveryRequestDto.fromCreate(createVo, memberUuid);
        DeliveryResponseDto result = deliveryService.createDelivery(dto, memberUuid);

        return new BaseResponseEntity<>("배송지가 등록되었습니다.", result.toVo());
    }

    // 배송지 목록 조회
    @Operation(summary = "배송지 목록 조회", description = "회원의 전체 배송지를 조회합니다.", tags = {"delivery"})
    @GetMapping("")
    public BaseResponseEntity<List<DeliveryResponseDto>> getDeliveriesByMember(
            @RequestHeader("Member-Uuid") String memberUuid ) {

        List<DeliveryResponseDto> result = deliveryService.getDeliveriesByMemberUuid(memberUuid);

        return new BaseResponseEntity<>("배송지 목록 조회 성공", result);
    }

    // 배송지 수정
    @Operation(summary = "배송지 수정", description = "기존 배송지를 비활성화하고 새 배송지를 생성합니다.", tags = {"delivery"})
    @PutMapping("/{deliveryUuid}")
    public BaseResponseEntity<DeliveryResponseVo> updateDelivery(
            @RequestBody DeliveryUpdateRequestVo updateVo,
            @RequestHeader("Member-Uuid") String memberUuid) {

        DeliveryResponseDto result = deliveryService.updateDelivery(
                updateVo.getDeliveryUuid(),
                DeliveryRequestDto.fromUpdate(memberUuid, updateVo),
                memberUuid
        );

        return new BaseResponseEntity<>("배송지가 수정되었습니다.", result.toVo());
    }

    // 배송지 삭제
    @Operation(summary = "배송지 삭제", description = "배송지를 삭제합니다.", tags = {"delivery"})
    @DeleteMapping("/{deliveryUuid}")
    public BaseResponseEntity<DeliveryResponseVo> deleteDelivery(
            @RequestBody DeliveryUpdateRequestVo updateVo,
            @RequestHeader("Member-Uuid") String memberUuid) {

        DeliveryResponseDto result = deliveryService.deleteDelivery(
                updateVo.getDeliveryUuid()
        );

        return new BaseResponseEntity<>("배송지가 삭제되었습니다.", result.toVo());
    }

    // 기본 배송지 설정
    @Operation(summary = "기본 배송지 설정", description = "기본 배송지로 설정합니다.", tags = {"delivery"})
    @PutMapping("/default")
    public BaseResponseEntity<DeliveryResponseVo> setDefaultDelivery(
            @RequestBody DeliveryUpdateRequestVo updateVo,
            @RequestHeader("Member-Uuid") String memberUuid) {

        DeliveryResponseDto result = deliveryService.setDefaultDelivery(
                updateVo.getDeliveryUuid(), memberUuid
        );

        return new BaseResponseEntity<>("기본 배송지가 설정되었습니다.", result.toVo());
    }
}
package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.application.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
@RequiredArgsConstructor
@Tag(name = "배송지 API", description = "배송지 관련 CRUD API")
public class DeliveryController {

    private final DeliveryService deliveryService;

    // 배송지 목록 조회
    @Operation(summary = "배송지 목록 조회", description = "회원 UUID로 해당 회원의 모든 배송지를 조회합니다.")
    @GetMapping("/{memberUuid}")
    public ResponseEntity<BaseResponseEntity<List<DeliveryResponseDto>>> getDeliveriesByMember(
            @PathVariable String memberUuid) {
        List<DeliveryResponseDto> response = deliveryService.getDeliveriesByMemberUuid(memberUuid);
        return ResponseEntity.ok(new BaseResponseEntity<>("배송지 목록 조회 성공", response));
    }

    // 배송지 생성
    @Operation(summary = "배송지 등록", description = "회원 UUID와 배송지 정보를 받아 새로운 배송지를 등록합니다.")
    @PostMapping("/{memberUuid}")
    public ResponseEntity<BaseResponseEntity<Void>> createDelivery(
            @RequestBody DeliveryRequestDto requestDto,
            @PathVariable String memberUuid) {
        deliveryService.createDelivery(requestDto, memberUuid);
        return ResponseEntity.ok(new BaseResponseEntity<>("배송지 등록 성공"));
    }

    // 배송지 수정
    @Operation(summary = "배송지 수정", description = "기존 배송지를 비활성화하고 새 배송지를 생성합니다.")
    @PutMapping("/{memberUuid}/{deliveryUuid}")
    public ResponseEntity<BaseResponseEntity<Void>> updateDelivery(
            @PathVariable String deliveryUuid,
            @RequestBody DeliveryRequestDto requestDto,
            @PathVariable String memberUuid) {
        deliveryService.updateDelivery(deliveryUuid, requestDto, memberUuid);
        return ResponseEntity.ok(new BaseResponseEntity<>("배송지 수정 성공"));
    }

    // 배송지 삭제
    @Operation(summary = "배송지 삭제", description = "배송지를 soft delete 방식으로 삭제 처리합니다.")
    @DeleteMapping("/{deliveryUuid}")
    public ResponseEntity<BaseResponseEntity<Void>> deleteDelivery(@PathVariable String deliveryUuid) {
        deliveryService.deleteDelivery(deliveryUuid);
        return ResponseEntity.ok(new BaseResponseEntity<>("배송지 삭제 성공"));
    }

    // 기본 배송지 설정
    @Operation(summary = "기본 배송지 설정", description = "기존 기본 배송지를 해제하고 해당 배송지를 기본 배송지로 설정합니다.")
    @PutMapping("defalut/{memberUuid}/{deliveryUuid}")
    public ResponseEntity<BaseResponseEntity<Void>> setDefaultDelivery(
            @PathVariable String memberUuid,
            @PathVariable String deliveryUuid) {

        deliveryService.setDefaultDelivery(deliveryUuid, memberUuid);
        return ResponseEntity.ok(new BaseResponseEntity<>(BaseResponseStatus.SUCCESS));
    }
}
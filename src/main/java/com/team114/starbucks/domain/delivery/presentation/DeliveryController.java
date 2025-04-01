package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.application.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    /**
     * 배송지 목록 조회
     */
    @GetMapping("/{memberUuid}")
    public ResponseEntity<List<DeliveryResponseDto>> getDeliveriesByMember(@PathVariable String memberUuid) {
        return ResponseEntity.ok(deliveryService.getDeliveriesByMemberUuid(memberUuid));
    }

    /**
     * 배송지 등록
     */
    @PostMapping("/{memberUuid}")
    public ResponseEntity<Void> createDelivery(
            @RequestBody DeliveryRequestDto requestDto,
            @PathVariable String memberUuid) {
        deliveryService.createDelivery(requestDto, memberUuid);
        return ResponseEntity.ok().build();
    }

    /**
     * 배송지 수정
     * 기존 row를 비활성화하고 새로운 row를 추가하는 방식
     */
    @PutMapping("/{deliveryUuid}")
    public ResponseEntity<Void> updateDelivery(
            @PathVariable String deliveryUuid,
            @RequestBody DeliveryRequestDto requestDto,
            @PathVariable String memberUuid) {
        deliveryService.updateDelivery(deliveryUuid, requestDto, memberUuid);
        return ResponseEntity.ok().build();
    }

    /**
     * 배송지 삭제 (Soft Delete)
     */
    @DeleteMapping("/{deliveryUuid}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable String deliveryUuid) {
        deliveryService.deleteDelivery(deliveryUuid);
        return ResponseEntity.ok().build();
    }
}
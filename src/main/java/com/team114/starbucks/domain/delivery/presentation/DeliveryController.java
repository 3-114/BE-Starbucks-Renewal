package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.domain.delivery.application.DeliveryService;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    // 배송지 등록
    @PostMapping
    public ResponseEntity<String> createDelivery(@RequestBody DeliveryRequestDto requestDto) {
        deliveryService.createDelivery(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("배송지가 등록되었습니다.");
    }

    // 배송지 전체 조회
    @GetMapping
    public ResponseEntity<List<DeliveryResponseDto>> getAllDeliveries() {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }

    // 배송지 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDelivery(@PathVariable Long id,
                                               @RequestBody DeliveryRequestDto requestDto) {
        deliveryService.updateDelivery(id, requestDto);
        return ResponseEntity.ok("배송지가 수정되었습니다.");
    }

    // 배송지 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.ok("배송지가 삭제되었습니다.");
    }

    // 기본 배송지 설정
    @PatchMapping("/{id}/default")
    public ResponseEntity<String> setDefaultDelivery(@PathVariable Long id) {
        deliveryService.setDefaultDelivery(id);
        return ResponseEntity.ok("기본 배송지가 설정되었습니다.");
    }
}
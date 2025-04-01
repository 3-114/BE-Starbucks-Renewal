package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;

import java.util.List;

public interface DeliveryService {

    // 새 배송지 등록
    void createDelivery(DeliveryRequestDto requestDto, String memberUuid);

    // 특정 회원의 모든 배송지 조회
    List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid);

    // 배송지 단건 조회
    DeliveryResponseDto getDeliveryByUuid(String deliveryUuid);

    // 기존 배송지를 비활성화하고 새 row 생성 (이력 보존)
    void updateDelivery(String oldDeliveryUuid, DeliveryRequestDto requestDto, String memberUuid);

    // soft delete 적용
    void deleteDelivery(String deliveryUuid);

    // 기본 배송지 설정 (기존 기본 배송지 해제 후 새로운 배송지 지정)
    void setDefaultDelivery(String deliveryUuid, String memberUuid);
}
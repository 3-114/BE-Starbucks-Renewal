package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.infrastructure.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public DeliveryResponseDto createDelivery(DeliveryRequestDto dto, String memberUuid) {

        Delivery savedDelivery = deliveryRepository.save(
                dto.toEntity(UUID.randomUUID().toString(), memberUuid)
        );

        return DeliveryResponseDto.fromEntity(savedDelivery);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid) {
        return deliveryRepository.findAllByMemberUuid(memberUuid).stream()
                .map(DeliveryResponseDto::fromEntity)
                .toList();
    }

    @Override
    @Transactional
    public DeliveryResponseDto updateDelivery(String deliveryUuid, DeliveryRequestDto dto, String memberUuid) {
        // 1. 기존 배송지 찾고 비활성화 처리
        Delivery oldDelivery = deliveryRepository.findByDeliveryUuid(deliveryUuid)
                .orElseThrow(() -> new IllegalArgumentException("기존 배송지를 찾을 수 없습니다."));

        oldDelivery.deactivate(); // active = false, deleted = false

        // 2. 새로운 배송지가 기본 배송지인 경우 기존 기본 배송지도 비활성화
        if (Boolean.TRUE.equals(dto.getDefaultAddress())) {
            deliveryRepository.findByMemberUuidAndDefaultAddressIsTrue(memberUuid)
                    .ifPresent(Delivery::deactivate);
        }

        Delivery newDelivery = dto.toEntity(UUID.randomUUID().toString(), memberUuid);
        Delivery savedDelivery = deliveryRepository.save(newDelivery); // 저장된 객체 반환

        return DeliveryResponseDto.fromEntity(savedDelivery); // 반환
    }

    @Override
    @Transactional
    public DeliveryResponseDto deleteDelivery(String deliveryUuid) {
        Delivery delivery = deliveryRepository.findByDeliveryUuid(deliveryUuid)
                .orElseThrow(() -> new IllegalArgumentException("배송지를 찾을 수 없습니다."));

        deliveryRepository.delete(delivery);

        return DeliveryResponseDto.fromEntity(delivery); // 삭제 전의 배송지 정보 반환
    }

    @Override
    @Transactional
    public DeliveryResponseDto setDefaultDelivery(String deliveryUuid, String memberUuid) {
        deliveryRepository.findByMemberUuidAndDefaultAddressIsTrue(memberUuid)
                .ifPresent(Delivery::deactivate); // 기존 기본 배송지 비활성화

        Delivery newDefault = deliveryRepository.findByDeliveryUuid(deliveryUuid)
                .orElseThrow(() -> new IllegalArgumentException("배송지를 찾을 수 없습니다."));

        newDefault.activateAsDefault(); // 새로운 배송지를 기본으로 설정

        return DeliveryResponseDto.fromEntity(newDefault); // 변경된 배송지 반환
    }
}
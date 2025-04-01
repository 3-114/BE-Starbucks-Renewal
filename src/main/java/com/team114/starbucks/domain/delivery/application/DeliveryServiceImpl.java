package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.infrastructure.DeliveryRepository;
import lombok.RequiredArgsConstructor;
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
    public void createDelivery(DeliveryRequestDto dto, String memberUuid) {
        Delivery delivery = dto.toEntity(UUID.randomUUID().toString(), memberUuid);
        deliveryRepository.save(delivery);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid) {
        return deliveryRepository.findAllByMemberUuid(memberUuid).stream()
                .map(DeliveryResponseDto::fromEntity)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DeliveryResponseDto getDeliveryByUuid(String deliveryUuid) {
        Delivery delivery = deliveryRepository.findByDeliveryUuid(deliveryUuid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 배송지입니다."));
        return DeliveryResponseDto.fromEntity(delivery);
    }

    @Override
    @Transactional
    public void updateDelivery(String oldDeliveryUuid, DeliveryRequestDto dto, String memberUuid) {
        Delivery oldDelivery = deliveryRepository.findByDeliveryUuid(oldDeliveryUuid)
                .orElseThrow(() -> new IllegalArgumentException("기존 배송지를 찾을 수 없습니다."));

        oldDelivery.deactivate(); // 기존 배송지 비활성화

        Delivery newDelivery = dto.toEntity(UUID.randomUUID().toString(), memberUuid);
        deliveryRepository.save(newDelivery);
    }

    @Override
    @Transactional
    public void deleteDelivery(String deliveryUuid) {
        Delivery delivery = deliveryRepository.findByDeliveryUuid(deliveryUuid)
                .orElseThrow(() -> new IllegalArgumentException("배송지를 찾을 수 없습니다."));
        deliveryRepository.delete(delivery); // soft delete 적용
    }

    @Override
    @Transactional
    public void setDefaultDelivery(String deliveryUuid, String memberUuid) {
        deliveryRepository.findByMemberUuidAndDefaultAddressIsTrue(memberUuid)
                .ifPresent(Delivery::deactivate);

        Delivery newDefault = deliveryRepository.findByDeliveryUuid(deliveryUuid)
                .orElseThrow(() -> new IllegalArgumentException("배송지를 찾을 수 없습니다."));

        newDefault.activateAsDefault();
    }
}
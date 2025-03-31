package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.infrastructure.DeliveryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Transactional
    public void createDelivery(DeliveryRequestDto requestDto) {
        // 기본 배송지인 경우 기존 기본 배송지 해제
        if (requestDto.isDefaultAddress()) {
            deliveryRepository.clearDefaultDelivery();
        }

        // UUID 생성 후 전달
        String uuid = UUID.randomUUID().toString();
        Delivery delivery = requestDto.toEntity(uuid);
        deliveryRepository.save(delivery);
    }

    @Transactional
    public void updateDelivery(Long id, DeliveryRequestDto requestDto) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 배송지입니다."));

        if (requestDto.isDefaultAddress()) {
            deliveryRepository.clearDefaultDelivery();
        }

        delivery.updateFrom(requestDto);
    }

    @Transactional
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

    @Transactional
    public void setDefaultDelivery(Long id) {
        deliveryRepository.clearDefaultDelivery();

        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 배송지입니다."));

        delivery.setAsDefault();
    }

    @Transactional
    public List<DeliveryResponseDto> getAllDeliveries() {
        return deliveryRepository.findAll().stream()
                .map(DeliveryResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public DeliveryResponseDto getDelivery(Long id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 배송지입니다."));

        return DeliveryResponseDto.fromEntity(delivery);
    }
}
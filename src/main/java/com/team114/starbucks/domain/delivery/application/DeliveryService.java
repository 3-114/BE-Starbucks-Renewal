package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;

import java.util.List;

public interface DeliveryService {

    void createDelivery(DeliveryRequestDto requestDto, String memberUuid);

    List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid);

    DeliveryResponseDto getDeliveryByUuid(String deliveryUuid);

    void updateDelivery(String oldDeliveryUuid, DeliveryRequestDto requestDto, String memberUuid);

    void deleteDelivery(String deliveryUuid);

    void setDefaultDelivery(String deliveryUuid, String memberUuid);
}
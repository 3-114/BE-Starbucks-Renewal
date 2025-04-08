package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryCreateRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryUpdateRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;

import java.util.List;

public interface DeliveryService {

    DeliveryResponseDto saveDelivery(DeliveryCreateRequestDto deliveryCreateRequestDto);

    List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid);

    DeliveryResponseDto updateDelivery(
            String deliveryUuid,
            DeliveryUpdateRequestDto deliveryUpdateRequestDto,
            String memberUuid
    );

    DeliveryResponseDto deleteDelivery(String deliveryUuid);
}
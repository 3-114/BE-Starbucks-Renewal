package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryCreateRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryUpdateRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliveryUuidResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetMyDeliveriesResponseDto;

import java.util.List;

public interface DeliveryService {

    DeliveryResponseDto saveDelivery(DeliveryCreateRequestDto deliveryCreateRequestDto);

    List<GetMyDeliveriesResponseDto> getCartDeliveriesByMemberUuid(String memberUuid);

    List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid);

    List<GetDeliveryUuidResponseDto> getDeliveryUuidsByMemberUuid(String memberUuid);

    void updateDelivery(DeliveryUpdateRequestDto deliveryUpdateRequestDto);

    void deleteDelivery(String deliveryUuid);
}
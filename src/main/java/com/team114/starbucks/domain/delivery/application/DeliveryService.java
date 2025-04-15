package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.CartDeliveryRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryCreateRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliverySelectedRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryUpdateRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliverySelectedResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliveryUuidResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetCartDeliveryResponseDto;

import java.util.List;

public interface DeliveryService {

    DeliveryResponseDto saveDelivery(DeliveryCreateRequestDto deliveryCreateRequestDto);

//    List<GetCartDeliveryResponseDto> getCartDeliveriesByMemberUuid(String memberUuid);

    List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid);

    List<GetDeliveryUuidResponseDto> getDeliveryUuidsByMemberUuid(String memberUuid);

    DeliverySelectedResponseDto updateSelectedDelivery(DeliverySelectedRequestDto deliverySelectedRequestDto);

    DeliverySelectedResponseDto getSelectedDeliveryByMemberUuid(String memberUuid);

    void updateDelivery(DeliveryUpdateRequestDto deliveryUpdateRequestDto);

    GetCartDeliveryResponseDto getCartDeliveryByUuid(CartDeliveryRequestDto cartDeliveryRequestDto);

    void deleteDelivery(String deliveryUuid);
}
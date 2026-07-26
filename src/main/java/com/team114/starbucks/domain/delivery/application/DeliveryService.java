package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.domain.delivery.dto.in.GetCartDeliveryReDto;
import com.team114.starbucks.domain.delivery.dto.in.CreateDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.in.GetSelectedDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.in.UpdateDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.out.GetAllDeliveryResDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliverySelectedReDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliveryUuidResDto;
import com.team114.starbucks.domain.delivery.dto.out.GetCartDeliveryResDto;

import java.util.List;

public interface DeliveryService {

    GetAllDeliveryResDto saveDelivery(CreateDeliveryReqDto createDeliveryReqDto);

    List<GetAllDeliveryResDto> getDeliveriesByMemberUuid(String memberUuid);

    List<GetDeliveryUuidResDto> getDeliveryUuidsByMemberUuid(String memberUuid);

    GetDeliverySelectedReDto updateSelectedDelivery(GetSelectedDeliveryReqDto getSelectedDeliveryReqDto);

    GetDeliverySelectedReDto getSelectedDeliveryByMemberUuid(String memberUuid);

    void updateDelivery(UpdateDeliveryReqDto updateDeliveryReqDto);

    GetCartDeliveryResDto getCartDeliveryByUuid(GetCartDeliveryReDto getCartDeliveryReDto);

    void deleteDelivery(String deliveryUuid);

}
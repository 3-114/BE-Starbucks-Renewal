package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryCreateRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryUpdateRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetMyDeliveriesResponseDto;
import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.infrastructure.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public DeliveryResponseDto saveDelivery(DeliveryCreateRequestDto deliveryCreateRequestDto) {

        String memberUuid = deliveryCreateRequestDto.getMemberUuid();

        // 1. 해당 회원의 기존 배송지가 하나도 없는 경우 → 무조건 기본 배송지로 설정
        boolean isFirst = deliveryRepository.findAllByMemberUuid(memberUuid).isEmpty();
        boolean isDefault = isFirst || deliveryCreateRequestDto.isDefaultAddress();

        // 2. 기존 기본 배송지가 있고, 새 배송지를 기본으로 등록 요청한 경우 → 기존 기본 false로 변경
        if (!isFirst && isDefault) {
            deliveryRepository.findByMemberUuidAndDefaultAddressTrue(memberUuid)
                    .ifPresent(existing -> {
                        existing.updateDefaultAddress(false);
                        deliveryRepository.save(existing);
                    });
        }

        Delivery newDelivery = deliveryCreateRequestDto.toEntity(UUID.randomUUID().toString(), isDefault);
        Delivery savedDelivery = deliveryRepository.save(newDelivery);

        return DeliveryResponseDto.from(savedDelivery);
    }

    @Override
    public List<GetMyDeliveriesResponseDto> getCartDeliveriesByMemberUuid(String memberUuid) {
        List<Delivery> deliveries = deliveryRepository.findAllByMemberUuid(memberUuid);
        return deliveries.stream().map(GetMyDeliveriesResponseDto::from).toList();
    }

    @Override
    public List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid) {
        List<Delivery> deliveries = deliveryRepository.findAllByMemberUuid(memberUuid);
        return deliveries.stream().map(DeliveryResponseDto::from).toList();
    }

    @Override
    @Transactional
    public DeliveryResponseDto updateDelivery(
            String deliveryUuid,
            DeliveryUpdateRequestDto deliveryUpdateRequestDto,
            String memberUuid
    ) {
        Delivery delivery = deliveryRepository.findByDeliveryUuid(deliveryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        Delivery updatedDelivery = Delivery.builder()
                .id(delivery.getId())
                .deliveryUuid(deliveryUuid)
                .memberUuid(memberUuid)
                .alias(deliveryUpdateRequestDto.getAlias())
                .recipient(deliveryUpdateRequestDto.getRecipient())
                .zoneCode(deliveryUpdateRequestDto.getZoneCode())
                .mainAddress(deliveryUpdateRequestDto.getMainAddress())
                .detailAddress(deliveryUpdateRequestDto.getDetailAddress())
                .phoneNumber1(deliveryUpdateRequestDto.getPhoneNumber1())
                .phoneNumber2(deliveryUpdateRequestDto.getPhoneNumber2())
                .deliveryMemo(deliveryUpdateRequestDto.getDeliveryMemo())
                .defaultAddress(deliveryUpdateRequestDto.isDefaultAddress())
                .build();

        deliveryRepository.save(updatedDelivery);

        return DeliveryResponseDto.from(updatedDelivery);
    }

    @Override
    @Transactional
    public DeliveryResponseDto deleteDelivery(String deliveryUuid) {

        Delivery delivery = deliveryRepository.findByDeliveryUuid(deliveryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        deliveryRepository.delete(delivery);

        return DeliveryResponseDto.from(delivery);
    }
}
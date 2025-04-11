package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryCreateRequestDto;
import com.team114.starbucks.domain.delivery.dto.in.DeliveryUpdateRequestDto;
import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliveryUuidResponseDto;
import com.team114.starbucks.domain.delivery.dto.out.GetMyDeliveriesResponseDto;
import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.infrastructure.DeliveryRepository;
import com.team114.starbucks.domain.delivery.vo.out.GetDeliveryUuidResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public DeliveryResponseDto saveDelivery(DeliveryCreateRequestDto deliveryCreateRequestDto) {

        String memberUuid = deliveryCreateRequestDto.getMemberUuid();
        boolean wantsDefault = deliveryCreateRequestDto.isDefaultAddress();

        List<Delivery> existingDeliveries = deliveryRepository.findAllByMemberUuid(memberUuid);
        boolean hasNoDelivery = existingDeliveries.isEmpty();
        boolean isDefault = false;

        // 1. 배송지가 아예 없는 경우 → 무조건 기본 배송지로 설정
        if (hasNoDelivery) {
            isDefault = true;

            // 2. 배송지가 있고, 사용자가 기본 배송지로 등록하고 싶어할 때
        } else if (wantsDefault) {
            isDefault = true;

            // 해당 회원의 모든 배송지를 기본 배송지 false로 초기화
            existingDeliveries.forEach(delivery -> {
                if (delivery.isDefaultAddress()) {
                    delivery.updateDefaultAddress(false);
                    deliveryRepository.save(delivery);
                }
            });
        }

        // 새 배송지 저장
        Delivery newDelivery = deliveryCreateRequestDto.toEntity(UUID.randomUUID().toString(), isDefault);
        Delivery savedDelivery = deliveryRepository.save(newDelivery);

        return DeliveryResponseDto.from(savedDelivery);
    }

    @Override
    public List<GetMyDeliveriesResponseDto> getCartDeliveriesByMemberUuid(String memberUuid) {
        List<Delivery> deliveries = deliveryRepository.findAllByMemberUuid(memberUuid);
        return deliveries.stream()
                .sorted((d1, d2) -> Boolean.compare(!d1.isDefaultAddress(), !d2.isDefaultAddress()))
                .map(GetMyDeliveriesResponseDto::from).toList();
    }

    @Override
    public List<DeliveryResponseDto> getDeliveriesByMemberUuid(String memberUuid) {
        List<Delivery> deliveries = deliveryRepository.findAllByMemberUuid(memberUuid);
        return deliveries.stream()
                .sorted((d1, d2) -> Boolean.compare(!d1.isDefaultAddress(), !d2.isDefaultAddress()))
                .map(DeliveryResponseDto::from).toList();
    }

    // 장바구니에서 DeliveryUuid 리스트 조회
    @Override
    public List<GetDeliveryUuidResponseDto> getDeliveryUuidsByMemberUuid(String memberUuid) {

        List<Delivery> deliveries = deliveryRepository.findAllByMemberUuid(memberUuid);
        return deliveries.stream()
                .sorted((d1, d2) -> Boolean.compare(!d1.isDefaultAddress(), !d2.isDefaultAddress()))
                .map(GetDeliveryUuidResponseDto::from).toList();
    }

    @Override
    @Transactional
    public void updateDelivery(DeliveryUpdateRequestDto deliveryUpdateRequestDto) {

        Delivery delivery = deliveryRepository.findByDeliveryUuid(deliveryUpdateRequestDto.getDeliveryUuid()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        deliveryRepository.save(deliveryUpdateRequestDto.toEntity(delivery));
    }

    @Override
    @Transactional
    public void deleteDelivery(String deliveryUuid) {

        Delivery delivery = deliveryRepository.findByDeliveryUuid(deliveryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        deliveryRepository.delete(delivery);
    }
}
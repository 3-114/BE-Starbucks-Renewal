package com.team114.starbucks.domain.delivery.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.delivery.dto.in.GetCartDeliveryReDto;
import com.team114.starbucks.domain.delivery.dto.in.CreateDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.in.GetSelectedDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.in.UpdateDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.out.GetAllDeliveryResDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliverySelectedReDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliveryUuidResDto;
import com.team114.starbucks.domain.delivery.dto.out.GetCartDeliveryResDto;
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
    public GetAllDeliveryResDto saveDelivery(CreateDeliveryReqDto createDeliveryReqDto) {

        String memberUuid = createDeliveryReqDto.getMemberUuid();
        boolean wantsDefault = createDeliveryReqDto.isDefaultAddress();

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

        Delivery newDelivery = createDeliveryReqDto.toEntity(UUID.randomUUID().toString(), isDefault);
        Delivery savedDelivery = deliveryRepository.save(newDelivery);

        return GetAllDeliveryResDto.from(savedDelivery);
    }


    @Override
    public List<GetAllDeliveryResDto> getDeliveriesByMemberUuid(String memberUuid) {
        List<Delivery> deliveries = deliveryRepository.findAllByMemberUuid(memberUuid);
        return deliveries.stream()
                .sorted((d1, d2) -> Boolean.compare(!d1.isDefaultAddress(), !d2.isDefaultAddress()))
                .map(GetAllDeliveryResDto::from).toList();
    }

    @Override
    public List<GetDeliveryUuidResDto> getDeliveryUuidsByMemberUuid(String memberUuid) {
        List<Delivery> deliveries = deliveryRepository.findAllByMemberUuid(memberUuid);
        return deliveries.stream()
                .sorted((d1, d2) -> Boolean.compare(!d1.isDefaultAddress(), !d2.isDefaultAddress()))
                .map(GetDeliveryUuidResDto::from).toList();
    }

    @Override
    @Transactional
    public GetDeliverySelectedReDto updateSelectedDelivery(GetSelectedDeliveryReqDto dto) {
        String selectedDeliveryUuid = dto.getDeliveryUuid();

        // 1. 해당 회원의 모든 배송지 isSelected → false
        List<Delivery> deliveries = deliveryRepository.findAllByMemberUuid(dto.getMemberUuid());
        for (Delivery delivery : deliveries) {
            if (delivery.isSelected()) {
                delivery.updateIsSelected(false);
                deliveryRepository.save(delivery);
            }
        }

        // 2. 선택된 배송지 UUID만 isSelected → true
        Delivery selectedDelivery = deliveryRepository.findByDeliveryUuid(selectedDeliveryUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        selectedDelivery.updateIsSelected(true);

        return GetDeliverySelectedReDto.from(deliveryRepository.save(selectedDelivery));
    }

    @Override
    public GetCartDeliveryResDto getCartDeliveryByUuid(GetCartDeliveryReDto getCartDeliveryReDto) {
        Delivery delivery = deliveryRepository
                .findByMemberUuidAndDeliveryUuid(getCartDeliveryReDto.getMemberUuid(), getCartDeliveryReDto.getDeliveryUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        return GetCartDeliveryResDto.from(delivery);
    }

    @Override
    public GetDeliverySelectedReDto getSelectedDeliveryByMemberUuid(String memberUuid) {
        Delivery selectedDelivery = deliveryRepository
                .findByMemberUuidAndIsSelectedTrue(memberUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        return GetDeliverySelectedReDto.from(selectedDelivery);
    }


    @Override
    @Transactional
    public void updateDelivery(UpdateDeliveryReqDto updateDeliveryReqDto) {
        Delivery delivery = deliveryRepository.findByDeliveryUuid(updateDeliveryReqDto.getDeliveryUuid()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        deliveryRepository.save(updateDeliveryReqDto.toEntity(delivery));
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
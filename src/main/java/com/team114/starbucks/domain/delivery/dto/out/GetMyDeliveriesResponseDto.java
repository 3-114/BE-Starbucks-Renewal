package com.team114.starbucks.domain.delivery.dto.out;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.out.GetMyDeliveriesResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetMyDeliveriesResponseDto {

    private String recipient;
    private String zoneCode;
    private String mainAddress;
    private String detailAddress;

    @Builder
    public GetMyDeliveriesResponseDto(
            String recipient,
            String zoneCode,
            String mainAddress,
            String detailAddress
    ) {
        this.recipient = recipient;
        this.zoneCode = zoneCode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
    }

    public static GetMyDeliveriesResponseDto from(Delivery delivery) {
        return GetMyDeliveriesResponseDto.builder()
                .recipient(delivery.getRecipient())
                .zoneCode(delivery.getZoneCode())
                .mainAddress(delivery.getMainAddress())
                .detailAddress(delivery.getDetailAddress())
                .build();
    }

    public GetMyDeliveriesResponseVo toVo() {
        return GetMyDeliveriesResponseVo.builder()
                .recipient(recipient)
                .zoneCode(zoneCode)
                .mainAddress(mainAddress)
                .detailAddress(detailAddress)
                .build();
    }

}

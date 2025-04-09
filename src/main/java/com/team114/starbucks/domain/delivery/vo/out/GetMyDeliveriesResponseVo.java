package com.team114.starbucks.domain.delivery.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetMyDeliveriesResponseVo {

    private String recipient;
    private String zoneCode;
    private String mainAddress;
    private String detailAddress;

    @Builder
    public GetMyDeliveriesResponseVo(
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

}

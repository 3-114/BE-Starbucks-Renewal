package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.vo.in.UpdateSelectedDeliveryReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetSelectedDeliveryReqDto {

    private String deliveryUuid;
    private String memberUuid;

    @Builder
    public GetSelectedDeliveryReqDto(String deliveryUuid, String memberUuid) {
        this.deliveryUuid = deliveryUuid;
        this.memberUuid = memberUuid;
    }

    public static GetSelectedDeliveryReqDto from(UpdateSelectedDeliveryReqVo updateSelectedDeliveryReqVo, String memberUuid
    ) {
        return GetSelectedDeliveryReqDto.builder()
                .deliveryUuid(updateSelectedDeliveryReqVo.getDeliveryUuid())
                .memberUuid(memberUuid)
                .build();
    }

}

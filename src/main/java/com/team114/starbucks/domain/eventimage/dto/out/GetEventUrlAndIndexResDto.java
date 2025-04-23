package com.team114.starbucks.domain.eventimage.dto.out;

import com.team114.starbucks.domain.eventimage.entity.EventImage;
import com.team114.starbucks.domain.eventimage.vo.out.GetEventUrlAndIndexResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetEventUrlAndIndexResDto {

    private String eventUrl;
    private int eventUrlIndex;

    @Builder
    public GetEventUrlAndIndexResDto(String eventUrl, int eventUrlIndex) {
        this.eventUrl = eventUrl;
        this.eventUrlIndex = eventUrlIndex;
    }

    public static GetEventUrlAndIndexResDto from(EventImage eventImage) {
        return GetEventUrlAndIndexResDto.builder()
                .eventUrl(eventImage.getEventUrl())
                .eventUrlIndex(eventImage.getEventUrlIndex())
                .build();
    }

    public GetEventUrlAndIndexResVo toVo() {
        return GetEventUrlAndIndexResVo.builder()
                .eventUrl(eventUrl)
                .eventUrlIndex(eventUrlIndex)
                .build();

    }
}

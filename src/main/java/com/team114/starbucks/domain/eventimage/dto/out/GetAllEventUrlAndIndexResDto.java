package com.team114.starbucks.domain.eventimage.dto.out;

import com.team114.starbucks.domain.eventimage.entity.EventImage;
import com.team114.starbucks.domain.eventimage.vo.out.GetAllEventUrlAndIndexResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllEventUrlAndIndexResDto {

    private String eventUrl;
    private int eventUrlIndex;

    @Builder
    public GetAllEventUrlAndIndexResDto(String eventUrl, int eventUrlIndex) {
        this.eventUrl = eventUrl;
        this.eventUrlIndex = eventUrlIndex;
    }

    public static GetAllEventUrlAndIndexResDto from(EventImage eventImage) {
        return GetAllEventUrlAndIndexResDto.builder()
                .eventUrl(eventImage.getEventUrl())
                .eventUrlIndex(eventImage.getEventUrlIndex())
                .build();
    }

    public GetAllEventUrlAndIndexResVo toVo() {
        return GetAllEventUrlAndIndexResVo.builder()
                .eventUrl(eventUrl)
                .eventUrlIndex(eventUrlIndex)
                .build();

    }
}
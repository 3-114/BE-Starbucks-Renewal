package com.team114.starbucks.domain.eventimage.dto.in;

import com.team114.starbucks.domain.eventimage.entity.EventImage;
import com.team114.starbucks.domain.eventimage.vo.in.CreateEventImageReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateEventImageReqDto {

    private String eventUuid;
    private String eventUrl;
    private int eventUrlIndex;

    @Builder
    public CreateEventImageReqDto(String eventUuid, String eventUrl, int eventUrlIndex) {
        this.eventUuid = eventUuid;
        this.eventUrl = eventUrl;
        this.eventUrlIndex = eventUrlIndex;
    }

    public static CreateEventImageReqDto from(CreateEventImageReqVo createEventImageReqVo) {
        return CreateEventImageReqDto.builder()
                .eventUuid(createEventImageReqVo.getEventUuid())
                .eventUrl(createEventImageReqVo.getEventUrl())
                .eventUrlIndex(createEventImageReqVo.getEventUrlIndex())
                .build();
    }

    public EventImage toEntity() {
        return EventImage.builder()
                .eventUuid(eventUuid)
                .eventUrl(eventUrl)
                .eventUrlIndex(eventUrlIndex)
                .build();
    }

}

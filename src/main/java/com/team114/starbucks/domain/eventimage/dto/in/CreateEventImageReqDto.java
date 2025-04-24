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

    @Builder
    public CreateEventImageReqDto(String eventUuid, String eventUrl) {
        this.eventUuid = eventUuid;
        this.eventUrl = eventUrl;
    }


    public static CreateEventImageReqDto from(CreateEventImageReqVo createEventImageReqVo) {
        return CreateEventImageReqDto.builder()
                .eventUuid(createEventImageReqVo.getEventUuid())
                .eventUrl(createEventImageReqVo.getEventUrl())
                .build();
    }


    public EventImage toEntity(int maxIndex) {
        return EventImage.builder()
                .eventUuid(eventUuid)
                .eventUrl(eventUrl)
                .eventUrlIndex(maxIndex + 1)
                .build();
    }

}

package com.team114.starbucks.domain.event.dto.out;

import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.vo.out.CreateEventResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateEventResDto {

    private String eventName;
    private String eventUuid;

    @Builder
    public CreateEventResDto(String eventName, String eventUuid) {
        this.eventName = eventName;
        this.eventUuid = eventUuid;
    }

    public static CreateEventResDto from(Event event) {
        return CreateEventResDto.builder()
                .eventName(event.getEventName())
                .eventUuid(event.getEventUuid())
                .build();
    }

    public CreateEventResVo toVo() {
        return CreateEventResVo.builder()
                .eventName(eventName)
                .eventUuid(eventUuid)
                .build();
    }
}

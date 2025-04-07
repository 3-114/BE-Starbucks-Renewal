package com.team114.starbucks.domain.event.dto.out;

import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.vo.out.CreateEventResVo;
import com.team114.starbucks.domain.event.vo.out.EventResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EventResponseDto {

    private String eventUuid;
    private String eventName;

    @Builder
    public EventResponseDto(String eventUuid, String eventName) {
        this.eventUuid = eventUuid;
        this.eventName = eventName;
    }

    public static EventResponseDto from(Event event) {
        return EventResponseDto.builder()
                .eventUuid(event.getEventUuid())
                .eventName(event.getEventName())
                .build();
    }

    public EventResponseVo toVo() {
        return EventResponseVo.builder()
                .eventUuid(eventUuid)
                .eventName(eventName)
                .build();


    }

}

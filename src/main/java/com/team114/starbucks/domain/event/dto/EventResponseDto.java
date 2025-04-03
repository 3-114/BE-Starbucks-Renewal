package com.team114.starbucks.domain.event.dto;

import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.vo.EventResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EventResponseDto {

    private String eventName;

    @Builder
    public EventResponseDto(
            String name
    ) {
        this.eventName = name;
    }

    public static EventResponseDto from(Event event) {
        return EventResponseDto.builder()
                .name(event.getEventName())
                .build();
    }


    public EventResponseVo toVo() {
        return EventResponseVo.builder()
                .eventName(eventName)
                .build();


    }

}

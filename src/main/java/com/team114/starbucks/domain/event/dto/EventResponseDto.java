package com.team114.starbucks.domain.event.dto;

import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.vo.EventResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EventResponseDto {

    private Long id;
    private String eventName;

    @Builder
    public EventResponseDto(Long id, String eventName) {
        this.id = id;
        this.eventName = eventName;
    }

    public static EventResponseDto from(Event event) {
        return EventResponseDto.builder()
                .id(event.getId())
                .eventName(event.getEventName())
                .build();
    }


    public EventResponseVo toVo() {
        return EventResponseVo.builder()
                .id(id)
                .eventName(eventName)
                .build();


    }

}

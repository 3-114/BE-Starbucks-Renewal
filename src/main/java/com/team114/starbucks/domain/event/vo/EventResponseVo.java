package com.team114.starbucks.domain.event.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EventResponseVo {
    private Long id;
    private String eventName
            ;

    @Builder
    public EventResponseVo(Long id, String eventName) {
        this.id = id;
        this.eventName = eventName;
    }
}

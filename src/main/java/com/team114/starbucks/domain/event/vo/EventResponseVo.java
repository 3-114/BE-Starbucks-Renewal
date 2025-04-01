package com.team114.starbucks.domain.event.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EventResponseVo {
    private String eventName;

    @Builder
    public EventResponseVo(String eventName) {
        this.eventName = eventName;
    }
}

package com.team114.starbucks.domain.event.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EventResponseVo {
    private String eventUuid;
    private String eventName;

    @Builder
    public EventResponseVo(String eventUuid, String eventName) {
        this.eventUuid = eventUuid;
        this.eventName = eventName;
    }
}
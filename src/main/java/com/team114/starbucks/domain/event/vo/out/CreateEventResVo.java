package com.team114.starbucks.domain.event.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateEventResVo {

    private String eventName;
    private String eventUuid;

    @Builder
    public CreateEventResVo(String eventName, String eventUuid) {
        this.eventName = eventName;
        this.eventUuid = eventUuid;
    }
}

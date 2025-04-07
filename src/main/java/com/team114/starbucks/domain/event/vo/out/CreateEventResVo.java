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

    @Getter
    public static class EventResponseVo {
        private String eventUuid;
        private String eventName;

        @Builder
        public EventResponseVo(String eventUuid, String eventName) {
            this.eventUuid = eventUuid;
            this.eventName = eventName;
        }
    }
}

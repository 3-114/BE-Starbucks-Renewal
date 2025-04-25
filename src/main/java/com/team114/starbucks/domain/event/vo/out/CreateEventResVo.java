package com.team114.starbucks.domain.event.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateEventResVo {

    private String eventName;
    private String eventUuid;

    @Builder
    public CreateEventResVo(String eventName, String eventUuid) {
        this.eventName = eventName;
        this.eventUuid = eventUuid;
    }

    @Getter
    @NoArgsConstructor
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

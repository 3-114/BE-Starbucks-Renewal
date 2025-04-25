package com.team114.starbucks.domain.event.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllEventResVo {

    private String eventUuid;
    private String eventName;

    @Builder
    public GetAllEventResVo(String eventUuid, String eventName) {
        this.eventUuid = eventUuid;
        this.eventName = eventName;
    }
}
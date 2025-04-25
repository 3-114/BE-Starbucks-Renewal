package com.team114.starbucks.domain.event.dto.out;

import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.vo.out.GetAllEventResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllEventResDto {

    private String eventUuid;
    private String eventName;

    @Builder
    public GetAllEventResDto(String eventUuid, String eventName) {
        this.eventUuid = eventUuid;
        this.eventName = eventName;
    }

    public static GetAllEventResDto from(Event event) {
        return GetAllEventResDto.builder()
                .eventUuid(event.getEventUuid())
                .eventName(event.getEventName())
                .build();
    }

    public GetAllEventResVo toVo() {
        return GetAllEventResVo.builder()
                .eventUuid(eventUuid)
                .eventName(eventName)
                .build();

    }
}
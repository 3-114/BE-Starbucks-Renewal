package com.team114.starbucks.domain.event.dto.out;

import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.vo.out.GetEventResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GetEventResDto {

    private String eventUuid;
    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;

    @Builder
    public GetEventResDto(String eventUuid, String eventName, LocalDate startDate, LocalDate endDate, Boolean isActive) {
        this.eventUuid = eventUuid;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public static GetEventResDto from(Event event) {
        return GetEventResDto.builder()
                .eventUuid(event.getEventUuid())
                .eventName(event.getEventName())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .isActive(event.getIsActive())
                .build();
    }

    public GetEventResVo toVo() {
        return GetEventResVo.builder()
                .eventUuid(eventUuid)
                .eventName(eventName)
                .startDate(startDate)
                .endDate(endDate)
                .isActive(isActive)
                .build();

    }
}

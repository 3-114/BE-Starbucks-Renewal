package com.team114.starbucks.domain.event.dto.out;

import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.vo.out.GetOneEventResVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetOneEventResDto {
    private String eventUuid;
    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;

    @Builder
    public GetOneEventResDto(String eventUuid, String eventName, LocalDate startDate, LocalDate endDate, Boolean isActive) {
        this.eventUuid = eventUuid;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public static GetOneEventResDto from(Event event) {

        return GetOneEventResDto.builder()
                .eventUuid(event.getEventUuid())
                .eventName(event.getEventName())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .isActive(event.getIsActive())
                .build();
    }

    public GetOneEventResVo toVo() {
        return GetOneEventResVo.builder()
                .eventUuid(eventUuid)
                .eventName(eventName)
                .startDate(startDate)
                .endDate(endDate)
                .isActive(isActive)
                .build();


    }
}

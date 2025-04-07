package com.team114.starbucks.domain.event.vo.in;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetOneEventResVo {

    private String eventUuid;
    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;

    @Builder
    public GetOneEventResVo(String eventUuid, String eventName, LocalDate startDate, LocalDate endDate, Boolean isActive) {
        this.eventUuid = eventUuid;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }
}

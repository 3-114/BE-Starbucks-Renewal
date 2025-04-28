package com.team114.starbucks.domain.event.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GetEventResVo {

    private String eventUuid;
    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;

    @Builder
    public GetEventResVo(String eventUuid, String eventName, LocalDate startDate, LocalDate endDate, Boolean isActive) {
        this.eventUuid = eventUuid;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }
}

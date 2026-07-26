package com.team114.starbucks.domain.event.dto.in;

import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.vo.in.CreateEventReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CreateEventReqDto {

    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;

    @Builder
    public CreateEventReqDto(String eventName, LocalDate startDate, LocalDate endDate, Boolean isActive) {
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public static CreateEventReqDto from(
            CreateEventReqVo createEventReqVo
    ) {
        return CreateEventReqDto.builder()
                .eventName(createEventReqVo.getEventName())
                .startDate(createEventReqVo.getStartDate())
                .endDate(createEventReqVo.getEndDate())
                .isActive(createEventReqVo.getIsActive())
                .build();
    }

    public Event toEntity(String eventUuid) {
        return Event.builder()
                .eventName(eventName)
                .eventUuid(eventUuid)
                .endDate(endDate)
                .startDate(startDate)
                .isActive(isActive)
                .build();
    }
}

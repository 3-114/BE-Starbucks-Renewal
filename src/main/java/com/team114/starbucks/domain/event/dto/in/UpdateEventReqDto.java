package com.team114.starbucks.domain.event.dto.in;

import com.team114.starbucks.domain.event.vo.in.UpdateEventReqVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UpdateEventReqDto {

    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;

    @Builder
    public UpdateEventReqDto(String eventName, LocalDate startDate, LocalDate endDate) {
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static UpdateEventReqDto from(UpdateEventReqVo updateEventReqVo) {
        return UpdateEventReqDto.builder()
                .eventName(updateEventReqVo.getEventName())
                .startDate(updateEventReqVo.getStartDate())
                .endDate(updateEventReqVo.getEndDate())
                .build();
    }

}

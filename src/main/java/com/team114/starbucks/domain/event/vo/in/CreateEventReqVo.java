package com.team114.starbucks.domain.event.vo.in;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
public class CreateEventReqVo {

    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;

}

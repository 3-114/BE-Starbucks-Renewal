package com.team114.starbucks.domain.event.vo.in;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UpdateEventReqVo {

    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;

}

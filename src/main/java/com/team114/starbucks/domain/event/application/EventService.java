package com.team114.starbucks.domain.event.application;

import com.team114.starbucks.domain.event.dto.EventResponseDto;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.dto.out.CreateEventResDto;

import java.util.List;

public interface EventService {

    List<EventResponseDto> findAllActiveEvents();

    CreateEventResDto saveEvent(CreateEventReqDto from);

}

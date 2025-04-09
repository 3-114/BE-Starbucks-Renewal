package com.team114.starbucks.domain.event.application;

import com.team114.starbucks.domain.event.dto.out.EventResponseDto;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.dto.in.UpdateEventReqDto;
import com.team114.starbucks.domain.event.dto.out.CreateEventResDto;
import com.team114.starbucks.domain.event.dto.out.GetOneEventResDto;

import java.util.List;

public interface EventService {

    List<EventResponseDto> findAllActiveEvents();

    CreateEventResDto saveEvent(CreateEventReqDto createEventReqDto);

    Void updateEvent(String eventUuid, UpdateEventReqDto updateEventReqDto);

    Void deleteEvent(String eventUuid);

    GetOneEventResDto findEventByUuid(String eventUuid);

}

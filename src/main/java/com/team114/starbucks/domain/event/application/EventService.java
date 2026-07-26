package com.team114.starbucks.domain.event.application;

import com.team114.starbucks.domain.event.dto.out.GetAllEventResDto;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.dto.in.UpdateEventReqDto;
import com.team114.starbucks.domain.event.dto.out.CreateEventResDto;
import com.team114.starbucks.domain.event.dto.out.GetEventResDto;

import java.util.List;

public interface EventService {

    List<GetAllEventResDto> findAllActiveEvents();

    CreateEventResDto saveEvent(CreateEventReqDto createEventReqDto);

    void updateEvent(String eventUuid, UpdateEventReqDto updateEventReqDto);

    void deleteEvent(String eventUuid);

    GetEventResDto findEventByUuid(String eventUuid);

}

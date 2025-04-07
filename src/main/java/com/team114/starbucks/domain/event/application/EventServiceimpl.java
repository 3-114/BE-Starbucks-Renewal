package com.team114.starbucks.domain.event.application;

import com.team114.starbucks.domain.event.dto.EventResponseDto;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.dto.out.CreateEventResDto;
import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.infrastructure.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceimpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<EventResponseDto> findAllActiveEvents() {

        List<Event> EventList = eventRepository.findByIsActiveTrue();

        List<EventResponseDto> responseDtoList = new ArrayList<>();

        for (Event event : EventList) {
            EventResponseDto dto = EventResponseDto.from(event);
            responseDtoList.add(dto);
        }

        return responseDtoList;
    }

    @Override
    public CreateEventResDto saveEvent(CreateEventReqDto createEventReqDto) {


        // [1] dto -> entity
        Event newEvent = createEventReqDto.toEntity(UUID.randomUUID().toString());

        // [2] repository 에 저장
        Event savedEvent = eventRepository.save(newEvent);

        // [3] entity -> dto
        return CreateEventResDto.from(savedEvent);

    }


}

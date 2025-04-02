package com.team114.starbucks.domain.event.application;

import com.team114.starbucks.domain.event.dto.EventResponseDto;
import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.infrastructure.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}

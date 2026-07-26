package com.team114.starbucks.domain.event.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.event.dto.out.GetAllEventResDto;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.dto.in.UpdateEventReqDto;
import com.team114.starbucks.domain.event.dto.out.CreateEventResDto;
import com.team114.starbucks.domain.event.dto.out.GetEventResDto;
import com.team114.starbucks.domain.event.entity.Event;
import com.team114.starbucks.domain.event.infrastructure.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventServiceimpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<GetAllEventResDto> findAllActiveEvents() {

        List<Event> EventList = eventRepository.findByIsActiveTrue();
        List<GetAllEventResDto> responseDtoList = new ArrayList<>();

        for (Event event : EventList) {
            GetAllEventResDto dto = GetAllEventResDto.from(event);
            responseDtoList.add(dto);
        }

        return responseDtoList;
    }

    @Transactional
    @Override
    public CreateEventResDto saveEvent(CreateEventReqDto createEventReqDto) {

        Event newEvent = createEventReqDto.toEntity(UUID.randomUUID().toString());
        Event savedEvent = eventRepository.save(newEvent);

        return CreateEventResDto.from(savedEvent);
    }

    @Transactional
    @Override
    public void updateEvent(String eventUuid, UpdateEventReqDto updateEventReqDto) {
        Event event = eventRepository.findByEventUuid(eventUuid).orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        Event updatedEvent = Event.builder()
                .id(event.getId())
                .eventUuid(event.getEventUuid())
                .eventName(event.getEventName() == null ? event.getEventName() : updateEventReqDto.getEventName())
                .startDate(event.getStartDate() == null ? event.getStartDate() : updateEventReqDto.getStartDate())
                .endDate(event.getEndDate() == null ? event.getEndDate() : updateEventReqDto.getEndDate())
                .isActive(event.getIsActive())
                .build();

        eventRepository.save(updatedEvent);
    }

    @Transactional
    @Override
    public void deleteEvent(String eventUuid) {
        eventRepository.deleteByEventUuid(eventUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
    }

    @Override
    public GetEventResDto findEventByUuid(String eventUuid) {
        Event event = eventRepository.findByEventUuid(eventUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
        return GetEventResDto.from(event);

    }
}

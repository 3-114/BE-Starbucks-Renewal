package com.team114.starbucks.domain.event.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.event.dto.out.EventResponseDto;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.dto.in.UpdateEventReqDto;
import com.team114.starbucks.domain.event.dto.out.CreateEventResDto;
import com.team114.starbucks.domain.event.dto.out.GetOneEventResDto;
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

    // 기획전 전체 조회
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

    // 기획전 생성
    @Transactional
    @Override
    public CreateEventResDto saveEvent(CreateEventReqDto createEventReqDto) {

        // [1] dto -> entity
        Event newEvent = createEventReqDto.toEntity(UUID.randomUUID().toString());

        // [2] repository 에 저장
        Event savedEvent = eventRepository.save(newEvent);

        // [3] entity -> dto
        return CreateEventResDto.from(savedEvent);

    }

    // 기획전 수정
    @Transactional
    @Override
    public Void updateEvent(String eventUuid, UpdateEventReqDto updateEventReqDto) {

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

        return null;
    }

    // 기획전 삭제
    @Transactional
    @Override
    public Void deleteEvent(String eventUuid) {
        eventRepository.deleteByEventUuid(eventUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
        return null;
    }


    // 기획전 단건 조회
    @Override
    public GetOneEventResDto findEventByUuid(String eventUuid) {
        Event event = eventRepository.findByEventUuid(eventUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
        return GetOneEventResDto.from(event);

    }


}

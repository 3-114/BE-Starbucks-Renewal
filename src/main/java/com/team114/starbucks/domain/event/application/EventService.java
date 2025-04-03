package com.team114.starbucks.domain.event.application;

import com.team114.starbucks.domain.event.dto.EventResponseDto;

import java.util.List;

public interface EventService {

    List<EventResponseDto> findAllActiveEvents();

}

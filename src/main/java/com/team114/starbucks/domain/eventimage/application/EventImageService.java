package com.team114.starbucks.domain.eventimage.application;

import com.team114.starbucks.domain.eventimage.dto.in.CreateEventImageReqDto;
import com.team114.starbucks.domain.eventimage.dto.out.GetAllEventUrlAndIndexResDto;

import java.util.List;

public interface EventImageService {

    List<GetAllEventUrlAndIndexResDto> getEventUrlAndIndex(String eventUuid);

    void createEventImage(CreateEventImageReqDto createEventImageReqDto);

}

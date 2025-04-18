package com.team114.starbucks.domain.eventimage.application;

import com.team114.starbucks.domain.eventimage.dto.out.GetEventUrlAndIndexResDto;
import com.team114.starbucks.domain.eventimage.entity.EventImage;
import com.team114.starbucks.domain.eventimage.infrastructure.EventImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventImageServiceImpl implements EventImageService {

    private final EventImageRepository eventImageRepository;

    @Override
    public List<GetEventUrlAndIndexResDto> getEventUrlAndIndex(String eventUuid) {
        List<EventImage> EventImageList = eventImageRepository.findByEventUuid(eventUuid);
        List<GetEventUrlAndIndexResDto> dtoList = new ArrayList<>();

        for (EventImage eventImage : EventImageList) {
            dtoList.add(GetEventUrlAndIndexResDto.from(eventImage));
        }

        return dtoList;

    }
}

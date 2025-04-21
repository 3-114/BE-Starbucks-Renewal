package com.team114.starbucks.domain.eventimage.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.eventimage.dto.in.CreateEventImageReqDto;
import com.team114.starbucks.domain.eventimage.dto.out.GetEventUrlAndIndexResDto;
import com.team114.starbucks.domain.eventimage.entity.EventImage;
import com.team114.starbucks.domain.eventimage.infrastructure.EventImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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

    @Transactional
    @Override
    public void createEventImage(CreateEventImageReqDto createEventImageReqDto) {
        try {
            eventImageRepository.save(createEventImageReqDto.toEntity());

        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_FIND);
        }
    }

}

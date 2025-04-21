package com.team114.starbucks.domain.eventimage.infrastructure;

import com.team114.starbucks.domain.eventimage.entity.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventImageRepository extends JpaRepository<EventImage, Long> {

    List<EventImage> findByEventUuid(String eventUuid);

}

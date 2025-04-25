package com.team114.starbucks.domain.eventimage.infrastructure;

import com.team114.starbucks.domain.eventimage.entity.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventImageRepository extends JpaRepository<EventImage, Long> {

    List<EventImage> findByEventUuid(String eventUuid);

    @Query("SELECT MAX(e.eventUrlIndex) FROM EventImage e WHERE e.eventUuid = :eventUuid")
    Optional<Integer> findMaxIndexByEventUuid(@Param("eventUuid") String eventUuid);

}

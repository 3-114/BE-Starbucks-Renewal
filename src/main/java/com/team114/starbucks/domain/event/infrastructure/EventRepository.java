package com.team114.starbucks.domain.event.infrastructure;

import com.team114.starbucks.domain.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByIsActiveTrue();

    Optional<Event> findByEventUuid(String eventUuid);

    Optional<Void> deleteByEventUuid(String eventUuid);

    @Query("SELECT e.eventUuid FROM Event e")
    List<String> findAllEventUuids();

}

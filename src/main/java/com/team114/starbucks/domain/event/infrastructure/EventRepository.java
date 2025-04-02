package com.team114.starbucks.domain.event.infrastructure;

import com.team114.starbucks.domain.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    //List <이벤트> findbyBooelan값 isTrue
    List<Event> findByIsActiveTrue();

}

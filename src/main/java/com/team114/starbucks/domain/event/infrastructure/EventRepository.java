package com.team114.starbucks.domain.event.infrastructure;

import com.team114.starbucks.domain.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


}

package com.team114.starbucks.domain.event.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Event {

    // 이벤트 Id
    @Id
//    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 이벤트 UUID
    @Column(name = "eventUuid", nullable = true)
    private String eventUuid;

    // 이벤트 명
    @Column(name = "eventName", nullable = true)
    private String eventName;

    // 시작 날짜
    @Column(name = "startDate", nullable = true)
    private Date startDate;

    // 종료 날짜
    @Column(name = "endDate", nullable = true)
    private Date endDate;

    @Builder
    public Event(Long id, String eventUuid, String eventName, Date startDate, Date endDate) {
        this.id = id;
        this.eventUuid = eventUuid;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

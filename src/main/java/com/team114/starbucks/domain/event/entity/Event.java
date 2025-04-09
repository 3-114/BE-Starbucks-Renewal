package com.team114.starbucks.domain.event.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Event {

    // 이벤트 Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 이벤트 UUID
    @Column(nullable = false, length = 50)
    private String eventUuid;

    // 이벤트 명
    @Column(nullable = false, length = 50)
    private String eventName;

    // 시작 날짜
    @Column(nullable = false)
    private LocalDate startDate;

    // 종료 날짜
    @Column(nullable = false)
    private LocalDate endDate;

    //진행 여부
    @Column(nullable = false)
    private Boolean isActive;

    @Builder
    public Event(Long id, String eventUuid, String eventName, LocalDate startDate, LocalDate endDate, Boolean isActive) {
        this.id = id;
        this.eventUuid = eventUuid;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }


}

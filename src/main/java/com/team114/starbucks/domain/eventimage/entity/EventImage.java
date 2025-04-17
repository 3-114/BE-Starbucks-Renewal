package com.team114.starbucks.domain.eventimage.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class EventImage {

    // 이벤트이미지 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventImageId;

    // 이벤트 UUID
    @Column(nullable = false, length = 50)
    private String eventUuid;

    // 이벤트 Url
    @Column(nullable = false)
    private String eventUrl;

    // 이벤트 Url 순서
    @Column(nullable = false)
    private Integer eventUrlIndex;

}

package com.team114.starbucks.domain.oauth2.entity;


import com.team114.starbucks.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OauthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String oauthProvider;

    @Column(nullable = false)
    private String oauthId;

    @Column(nullable = false)
    private String email;


}

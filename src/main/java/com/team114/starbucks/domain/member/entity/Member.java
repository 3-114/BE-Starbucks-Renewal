package com.team114.starbucks.domain.member.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.member.enums.Gender;
import com.team114.starbucks.domain.member.enums.UserRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    // 회원 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 회원 UUID
    private String memberUuid;

    // 닉네임
    private String nickname;

    // 비밀번호
    private String password;

    // 이름
    private String name;

    // 성별
    @Enumerated(EnumType.STRING)
    private Gender gender;

    // 생년월일
    private Date birthday;

    // 이메일
    private String email;

    //asdfasfasdfasdf

    // 휴대폰 번호
    private String phoneNumber;

    // 생성일자
    private LocalDateTime createdAt;

    // 수정일자
    private LocalDateTime modifiedAt;

    // 삭제 여부
    private Boolean deleted;

    // 유저 권한
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Builder
    public Member(
            Long id,
            String memberUuid,
            String nickname,
            String password,
            String name,
            Gender gender,
            Date birthday,
            String email,
            String phoneNumber,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            Boolean deleted,
            UserRole userRole
    ) {
        this.id = id;
        this.memberUuid = memberUuid;
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deleted = deleted;
        this.userRole = userRole;
    }

}

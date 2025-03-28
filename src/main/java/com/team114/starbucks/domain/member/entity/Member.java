package com.team114.starbucks.domain.member.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.member.enums.Gender;
import com.team114.starbucks.domain.member.enums.UserRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity implements UserDetails {

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

    // 휴대폰 번호
    private String phoneNumber;

    // 생성일자
    private LocalDateTime createdAt;

    // 수정일자
    private LocalDateTime modifiedAt;

    // 삭제 여부
    private Boolean deleted;

    // 유저 권한
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

    // 사용자가 가진 권한을 List 로 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    // 멤버 식별자 (uuid) 반환
    @Override
    public String getUsername() {
        return this.memberUuid;
    }

    // 계정 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있는지 여부
    // 예 : 로그인 실패 5회 시 계정 잠김 등의 로직 제어
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 자격 증명 (비밀번호)의 만료 여부 판단
    // 비밀번호 주기적 변경 정책이 있을 때 사용
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 상태 여부 판단
    // 비활성화된 계정, 탈퇴당한 회원 등의 판단 및 처리 제어
    @Override
    public boolean isEnabled() {
        return true;
    }
}

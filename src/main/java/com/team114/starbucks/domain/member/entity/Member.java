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

import java.io.Serializable;
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
    private String uuid;

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
            String uuid,
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
        this.uuid = uuid;
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

    /**
     *  UserDetails 인터페이스 구현
     *  1. getAuthorities()
     *  2. getUsername()
     *  3. isAccountNonExpired()
     *  4. isAccountNonLocked()
     *  5. isCredentialsNonExpired()
     *  6. isEnabled()
     */

    // 현재 사용자가 가지고 있는 권한(UserRole) 목록을 반환하는 메서드
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    // 사용자의 식별자(UUID) 반환
    @Override
    public String getUsername() {
        return uuid;
    }

    // 계정이 만료되었는지의 여부
    // 만료 기능을 따로 구현하지 않기 때문에 true 로 고정
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있는지의 여부 (예 : 로그인 실패 5회 시 계정을 잠근다. 할 때 사용)
    // 잠금 상태의 로직이 없기 때문에 true 로 고정
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Credentials(자격증명(비밀번호 등))이 만료되었는지의 여부
    // (예 : 비밀번호 변경 주기 90일 같은 정책이 있을 때 사용)
    // 아직 로직이 없기 때문에 true 로 고정
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화 상태인지의 여부
    // 탈퇴한 사용자, 이메일 인증이 안된 사용자 등을 비활성화 처리 가능
    // 활성 여부 필드(isActive, enabled 등)을 만들어서 여기 매핑하면 관리가 쉬움
    // 아직 로직이 없기 때문에 true 로 고정
    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.team114.starbucks.domain.member.infrastructure;

import com.team114.starbucks.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    Optional<Member> findByMemberUuid(String memberUuid);
}

package com.team114.starbucks.domain.member.infrastructure;

import com.team114.starbucks.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

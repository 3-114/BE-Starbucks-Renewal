package com.team114.starbucks.domain.auth.userDetails;

import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    /**
     * 1. loadByUsername
     * @param memberUuid
     * @return
     */

    // 멤버 객체를 CustomUserDetails 로 생성
    @Override
    public UserDetails loadUserByUsername(String memberUuid) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberUuid(memberUuid)
                .orElseThrow(() -> new IllegalArgumentException(memberUuid));

        return new CustomUserDetails(member);
    }
}

package com.team114.starbucks.common.config;

import com.team114.starbucks.domain.auth.userDetails.CustomUserDetails;
import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@RequiredArgsConstructor
@Configuration
public class ApplicationConfig {

    private final MemberRepository memberRepository;

    // 멤버 UUID 로 CustomUserDetails 조회
    @Bean
    public UserDetailsService userDetailsService() {
        return uuid -> {
            Member member = memberRepository.findByMemberUuid(uuid)
                    .orElseThrow(() -> new UsernameNotFoundException("해당 UUID 를 가진 회원이 없습니다."));

            return new CustomUserDetails(member);
        };
    }

    // AuthenticationManager 를 통해 여러 AuthenticationProvider 를 다룰 수 있음
    // 다중 인증 전략 가능
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return new ProviderManager(
                Arrays.asList(
                        daoAuthenticationProvider()
                )
        );
    }

    // DAO : Data Access Object
    // DB 에 저장된 사용자 정보로 인증하는 방식
    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    // 패스워드 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package com.team114.starbucks.common.config;

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

import java.util.Arrays;

@RequiredArgsConstructor
@Configuration
public class ApplicationConfig {

    private final MemberRepository memberRepository;

    // Member UUID 로 Member 조회
    @Bean
    public UserDetailsService getUserDetailsService() {
        return uuid -> {
            return memberRepository.findByMemberUuid(uuid)
                    // Todo[2] : 예외처리 커스텀하기
                    .orElseThrow(() -> new IllegalArgumentException(uuid));
        };
    }

    // 인증 흐름 커스터마이징
    // 다양한 인증 전략을 직접 등록해야할 때 사용 (for 소셜로그인 확장 가능성)
    @Bean
    public AuthenticationManager getAuthenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return new ProviderManager(
                Arrays.asList(
                        daoAuthenticationProvider()
                )
        );
    }

    //
    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService();
        daoAuthenticationProvider.setPasswordEncoder();
    }


}

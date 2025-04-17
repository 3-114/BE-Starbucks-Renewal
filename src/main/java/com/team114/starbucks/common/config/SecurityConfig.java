package com.team114.starbucks.common.config;

import com.team114.starbucks.common.exception.BaseExceptionHandlerFilter;
import com.team114.starbucks.common.jwt.JwtAuthenticationFilter;
import com.team114.starbucks.domain.oauth2.application.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider oAuthAuthenticationProvider;
    private final AuthenticationProvider daoAuthenticationProvider;
    private final CustomOAuth2UserService customOAuth2UserService;



    // 다른 도메인 (클라이언트 포함) 에서 오는 요청의 허용 설정을 판단하는 필터
    // 최우선 순위 필터 (만약 여러 필터를 사용 중이라면, CorsFilter 의 순서를 가장 빠르게)
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setExposedHeaders(List.of("Authorization", "Content-Type", "X-CSRF-TOKEN", "Set-Cookie"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // security filter chain 2개 이상이면 매핑해줄 것.
//        http
//                .securityMatchers((auth) -> auth.requestMatchers("/user"));

        // csrf disable
        http
            .csrf(AbstractHttpConfigurer::disable);// CSRF 비활성화 (Jwt 사용 시 필요하지 않음)
        //From Login disable
        http
                .formLogin((auth) -> auth.disable());
        //Http Basic disable
        http
                .httpBasic((auth) -> auth.disable());
        // oauth2
        http
                .oauth2Login((oauth2) -> oauth2
                        .userInfoEndpoint((userInfoEndpointConfig -> userInfoEndpointConfig
                                .userService(customOAuth2UserService))));
        // 경로별 인가작업
        http
            .authorizeHttpRequests(
                    authorizeRequests -> authorizeRequests
                            .requestMatchers(
                                    "/api/v1/**",
                                    "/swagger-ui/**",
                                    "/swagger-ui.html",
                                    "/v3/api-docs/**",
                                    "/error"
                            ).permitAll()
                            .requestMatchers(
                                    "api/v1/auth-service/"
                            )
                            .authenticated()
                            .anyRequest()
                            .authenticated()
            );
        // 세션 설정 : STATELESS
        http
                .sessionManagement(
                        sessionManagement -> sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(daoAuthenticationProvider)
                .authenticationProvider(oAuthAuthenticationProvider) // TODO : 콤마로 한번에 추가해도 됨
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class                              )
                .addFilter(corsFilter());

        return http.build();
    }
}

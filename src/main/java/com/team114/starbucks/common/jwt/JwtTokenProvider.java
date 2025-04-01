//package com.team114.starbucks.common.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import lombok.RequiredArgsConstructor;
//import org.springframework.core.env.Environment;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.security.Key;
//import java.util.Date;
//import java.util.function.Function;
//
//@RequiredArgsConstructor
//@Service
//public class JwtTokenProvider {
//
//    private final Environment env;
//    private static final String BEARER_PREFIX = "Bearer ";
//    private static final long TOKEN_EXPIRE_TIME = 24 * 60 * 60 * 1000; // 24시간
//
//    /**
//     * 1. 액세스 토큰 생성
//     * 2. 토큰에서 uuid 가져오기
//     * 3. Claims 에서 원하는 클레임 (멤버 uuid) 추출
//     * 4. 토큰에서 모든 클레임 추출
//     */
//
//    /**
//     * 1. 액세스 토큰 생성
//     *
//     * @param authentication
//     * @return 액세스 토큰
//     */
//    public String generateAccessToken(Authentication authentication) {
//
//
//        // Jwt 의 클레임 (Payload) 객체를 생성
//        Claims claims = Jwts.claims().subject(authentication.getName()).build();
//        Date now = new Date();
//        // 기본 만료 기한 : 30분
//        Date expiration = new Date(now.getTime() + TOKEN_EXPIRE_TIME);
//
//        return BEARER_PREFIX +
//                Jwts.builder()
//                .signWith(getSignKey())
//                .claims(claims)
//                .issuedAt(now)
//                .expiration(expiration)
//                .compact();
//    }
//
//    private Key getSignKey() {
//        return Keys.hmacShaKeyFor(env.getProperty("spring.jwt.secret.key").getBytes());
//    }
//
//    /**
//     * 2. 토큰에서 uuid 가져오기
//     *
//     * @param token
//     * @return jwt 토큰에서 추출한 사용자 UUID 반환
//     * @throws IllegalArgumentException
//     */
//    public String validateAndGetUserUuid(String token) throws IllegalStateException {
//        try {
//            return extractClaim(token, Claims::getSubject);
//        } catch (NullPointerException e) {
//            throw new IllegalArgumentException("토큰에 담긴 유저 정보가 없습니다.");
//        }
//    }
//
//    /**
//     * 3. Claims 에서 원하는 클레임 (멤버 uuid) 추출
//     *
//     * @param token
//     * @param claimsResolver : jwt 토큰에서 추출한 정보를 어떻게 처리할지 결정하는 함수
//     * @return
//     */
//    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        Claims claims = extractAllclaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    /**
//     * 4. 토큰에서 모든 클레임 추출
//     *
//     * @param token
//     * @return
//     */
//    private Claims extractAllclaims(String token) {
//        return Jwts.parser()
//                .verifyWith((SecretKey) getSignKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//}

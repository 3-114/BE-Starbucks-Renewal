package com.team114.starbucks.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.common.response.BaseResponseStatus;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

@Slf4j
@Component
public class BaseExceptionHandlerFilter extends OncePerRequestFilter {

    /**
     * Controller 에 진입하기 전
     * OncePerRequestFilter 나 Spring Security 필터 안에서 발생한 예외는
     * BaseExceptionHandler (GlobalExceptionHandler) 가 못잡기 때문에
     * 필터에서 직접 처리해야 함
     */
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BaseException e) {
            log.error("BaseException -> {}({})", e.getStatus(), e.getStatus().getMessage(), e);
            setErrorResponse(response, e);
        } catch (AuthenticationException e) {
            log.error("AuthenticationException -> {}", e.getMessage(), e);
            setErrorResponse(response, new BaseException(BaseResponseStatus.NO_SIGN_IN));
        }
    }

    private void setErrorResponse(HttpServletResponse response,
                                  BaseException be) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        BaseResponseEntity<Void> baseResponse = new BaseResponseEntity<>(be.getStatus());
        try {
            response.getWriter().write(objectMapper.writeValueAsString(baseResponse));
        } catch (IOException e) {
            log.error("Exception occurred", e);
        }
    }
}

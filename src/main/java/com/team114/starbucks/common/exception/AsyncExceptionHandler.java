package com.team114.starbucks.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    /**
     * 비동기 예외 처리 인터페이스 :
     * 비동기 메서드에서 발생한 예외를 잡아서 로그로 남기거나 추가 처리(알림 등)해주는 핸들러
     * @param ex
     * @param method
     * @param params
     */

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        if (ex instanceof BaseException baseException) {
            log.error("BaseException: [{}] {}", baseException.getStatus(), baseException.getStatus().getMessage());
        }
        log.error("EventException: ", ex);
    }
}

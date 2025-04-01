//package com.team114.starbucks.common.exception;
//
//import com.team114.starbucks.common.response.BaseResponseEntity;
//import com.team114.starbucks.common.response.BaseResponseStatus;
//import io.swagger.v3.oas.annotations.Hidden;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@Slf4j
//@RestControllerAdvice
//@Hidden // 스웨거 애노테이션으로 스웨거에서 컨트롤러를 숨길 때 사용되는 애노테이션
//public class BaseExceptionHandler {
//
//    /**
//     *  발생한 예외 처리
//     */
//    @ExceptionHandler(BaseException.class)
//    protected ResponseEntity<BaseResponseEntity<Void>> BaseError(BaseException e) {
//        BaseResponseEntity<Void> response = new BaseResponseEntity<>(e.getMessage());
//        log.error("BaseException -> {}({})", e.getStatus(), e.getStatus().getMessage(), e);
//        return new ResponseEntity<>(response, response.httpStatus());
//    }
//
//    /**
//     * security 인증 에러
//     * 아이디가 없거나 비밀번호가 틀린 경우 AuthenticationManager 예외 발생
//     *
//     * @return FAILED_TO_LOGIN 에러 response
//     */
//    @ExceptionHandler(BadCredentialsException.class)
//    protected ResponseEntity<BaseResponseEntity<Void>> handleBadCredentialsException(BadCredentialsException e) {
//        BaseResponseEntity<Void> response = new BaseResponseEntity<>(BaseResponseStatus.FAILED_TO_LOGIN);
//        log.error("BadCredentialsException: ", e);
//        return new ResponseEntity<>(response, response.httpStatus());
//    }
//
//    /**
//     * 런타임 에러
//     */
//    @ExceptionHandler(RuntimeException.class)
//    protected ResponseEntity<BaseResponseEntity<Void>> RuntimeError(RuntimeException e) {
//        BaseResponseEntity<Void> response = new BaseResponseEntity<>(BaseResponseStatus.INTERNAL_SERVER_ERROR);
//        log.error("RuntimeException: ", e);
//        for (StackTraceElement ste : e.getStackTrace()) {
//            System.out.println(ste);
//        }
//        return new ResponseEntity<>(response, response.httpStatus());
//    }
//}

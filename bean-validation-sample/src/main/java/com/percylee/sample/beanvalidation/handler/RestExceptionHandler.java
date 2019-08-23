package com.percylee.sample.beanvalidation.handler;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * RestExceptionHandler: 拦截程序中抛出的异常，定制化返回结果
 * Create by 李鹏翔[lipengxiang1@xiaomi.com] on 18-6-1.
 */
@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RestExceptionResult> handleConstraintViolationException(ConstraintViolationException e) {
        String msg = e.getConstraintViolations().stream().map(x -> x.getMessage()).collect(Collectors.joining(","));
        log.info("[ConstraintViolationException] {}", msg);
        RestExceptionResult result = new RestExceptionResult(HttpStatus.BAD_REQUEST.value(), Type.INFO, msg);
        return ResponseEntity.status(result.getCode()).body(result);
    }


    @Setter
    @Getter
    public static class RestExceptionResult {

        private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private int code;

        private String message;

        private boolean success;

        private String time;

        private String type;

        public RestExceptionResult() {
            this(500, Type.ERROR, "服务器内部错误");
        }

        public RestExceptionResult(Integer code, Type type, Throwable e) {
            this(code, type, e.getMessage());
        }

        public RestExceptionResult(Integer code, Type type, String message) {
            this.code = code;
            this.message = message;
            this.type = type.name();
            this.success = false;
            this.time = now();
        }

        private String now() {
            return format.format(new Date());
        }
    }

    public enum Type {
        INFO,
        WARN,
        ERROR
    }

}

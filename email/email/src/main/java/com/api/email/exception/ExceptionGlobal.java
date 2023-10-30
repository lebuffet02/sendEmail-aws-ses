package com.api.email.exception;


import com.api.email.TimeUtils.TimeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionGlobal extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Object> pessoasException(EmailException e) {
        return new ResponseEntity<>(getMap(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    private Map<String, Object> getMap(String e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", TimeUtils.formatDate(new Date()));
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("message", e);
        return body;
    }
}

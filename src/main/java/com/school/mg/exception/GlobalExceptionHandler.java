package com.school.mg.exception;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<APIError> validationException(
             ValidationException ex, 
             HttpServletRequest request){
        
       log.error("validation exception : "+  
                  ex.getLocalizedMessage()+
                 " for "+ 
                  request.getRequestURI() );
        
        return new ResponseEntity<>(
                APIError.builder()
                .errorMessage(ex.getLocalizedMessage())
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .customMessage("Request is not valid")
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<APIError> genericException(
             Exception ex, 
             HttpServletRequest request){
        
        log.error("exception : "+ 
                 ex.getLocalizedMessage()+ 
                 " for "+ 
                 request.getRequestURI() );
        
        return new ResponseEntity<>(
             APIError.builder()
             .errorMessage(ex.getLocalizedMessage()) 
             .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
             .request(request.getRequestURI())
             .requestType(request.getMethod())
             .customMessage("Could not process request")
             .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
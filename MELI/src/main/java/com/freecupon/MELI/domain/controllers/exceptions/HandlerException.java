package com.freecupon.MELI.domain.controllers.exceptions;

import com.freecupon.MELI.domain.dto.ErrorDto;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Log
public class HandlerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeException(RuntimeException ex){
        ErrorDto error = ErrorDto.builder()
                .code("Rt-Exc")
                .message("Ha ocurrido un error, se deben verificar los datos enviados")
                .build();
        log.info("Mensaje de error:" + ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

package com.freecupon.MELI.domain.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorDtoTest {
    @Test
    @DisplayName(value = "Prueba para settear y obtener los valores de ErroDto")
    void setAndGet(){
        ErrorDto errorDto = ErrorDto.builder()
                .code("Prueba")
                .message("Mensaje de prueba")
                .build();

        Assertions.assertEquals("Mensaje de prueba", errorDto.getMessage());
        Assertions.assertEquals("Prueba", errorDto.getCode());
    }
}
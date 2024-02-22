package com.freecupon.MELI.domain.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemPriceTest {
    @Test
    @DisplayName(value = "Prueba para settear y obtener los valores de ItemPrice")
    void setAndGet(){
        ItemPrice itemPrice = new ItemPrice();
        itemPrice.setId("MLA1");
        itemPrice.setPrice(123.4);

        Assertions.assertEquals("MLA1", itemPrice.getId());
        Assertions.assertEquals(123.4, itemPrice.getPrice());
    }
}
package com.freecupon.MELI.domain.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemsCouponInfoTest {
    @Test
    @DisplayName(value = "Prueba para settear y obtener los valores de ItemsCouponInfo")
    void setAndGet(){
        ItemsCouponInfo itemsCouponInfo = new ItemsCouponInfo();
        itemsCouponInfo.setAmount(123.4);
        List<String> ids = new ArrayList<>();
        ids.add("MLA1");
        ids.add("MLA2");
        ids.add("MLA3");
        itemsCouponInfo.setItems_ids(ids);

        Assertions.assertEquals("MLA3", itemsCouponInfo.getItems_ids().get(2));
        Assertions.assertEquals(123.4, itemsCouponInfo.getAmount());
    }
}
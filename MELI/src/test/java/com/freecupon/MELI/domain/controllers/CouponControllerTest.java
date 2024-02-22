package com.freecupon.MELI.domain.controllers;

import com.freecupon.MELI.domain.dto.ItemsCouponInfo;
import com.freecupon.MELI.domain.services.coupon.impl.CouponImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


class CouponControllerTest {
    private final ItemsCouponInfo itemsCouponInfo = new ItemsCouponInfo();
    private final ItemsCouponInfo itemsCouponInfoResponse = new ItemsCouponInfo();

    @BeforeEach
    void initMethod(){
        itemsCouponInfo.setAmount(123.4);
        List<String> ids = new ArrayList<>();
        ids.add("MLA1");
        ids.add("MLA2");
        ids.add("MLA3");
        itemsCouponInfo.setItems_ids(ids);

        itemsCouponInfoResponse.setAmount(89.9);
        List<String> idsResponse = new ArrayList<>();
        ids.add("MLA1");
        ids.add("MLA2");
        itemsCouponInfoResponse.setItems_ids(idsResponse);
    }

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private CouponImpl couponImpl;

    @InjectMocks
    private CouponController couponController;

    @Test
    @DisplayName(value = "MaximizeCoupon")
    void maximizeCoupon(){

        Mockito.when(couponImpl.maximizeCoupon(itemsCouponInfo)).thenReturn(itemsCouponInfoResponse);

        ResponseEntity<ItemsCouponInfo> response =  couponController.maximizeCoupon(itemsCouponInfo);
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(89.9, Objects.requireNonNull(response.getBody()).getAmount());
    }
}
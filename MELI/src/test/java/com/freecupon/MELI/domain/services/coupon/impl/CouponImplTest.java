package com.freecupon.MELI.domain.services.coupon.impl;

import com.freecupon.MELI.domain.dto.ItemsCouponInfo;
import com.freecupon.MELI.helpers.utils.ItemsPrices;
import com.freecupon.MELI.helpers.utils.TotalCalculations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CouponImplTest {


    private ItemsCouponInfo itemsCouponInfo = new ItemsCouponInfo();

    @BeforeEach
    void initMethod(){
        itemsCouponInfo.setAmount(700000.0);
        List<String> itemsId = new ArrayList<>();
        itemsId.add("MLA1397131107");
        itemsId.add("MLA1640831298");
        itemsId.add("MLA1373701839");
        itemsCouponInfo.setItems_ids(itemsId);
    }

    @Spy
    private TotalCalculations couponUse;

    @Mock
    private ItemsPrices itemsPrices;

    @InjectMocks
    private CouponImpl cuponImpl;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void maximizeCoupon() {

        ItemsCouponInfo reponse = cuponImpl.maximizeCoupon(itemsCouponInfo);
        Assertions.assertEquals(reponse.getItems_ids().size(),0);
    }
}
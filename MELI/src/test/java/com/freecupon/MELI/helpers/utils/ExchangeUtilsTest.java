package com.freecupon.MELI.helpers.utils;

import com.freecupon.MELI.domain.dto.ItemsCouponInfo;
import com.freecupon.MELI.domain.services.exchanged.impl.ItemExchangedImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class ExchangeUtilsTest {

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


    @Mock
    private ItemExchangedImpl exchangedImpl;

    @InjectMocks
    private ExchangeUtils exchangeUtils;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName(value = "updateExchaged")
    void maximizeCoupon(){

        exchangeUtils.updateExchaged(itemsCouponInfo.getItems_ids());

        Mockito.verify(exchangedImpl).updateItemExchanged(itemsCouponInfo.getItems_ids().get(2));

    }

}
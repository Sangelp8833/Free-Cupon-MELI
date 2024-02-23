package com.freecupon.MELI.domain.controllers;

import com.freecupon.MELI.domain.dto.ItemsCouponInfo;
import com.freecupon.MELI.domain.dto.ItemsExchangedDto;
import com.freecupon.MELI.domain.services.exchanged.impl.ItemExchangedImpl;
import com.freecupon.MELI.helpers.utils.ExchangeUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = ItemsExchangedController.EXCHANGED_URL)
@Tag(name = "CouponRest")
public class ItemsExchangedController {

    public static final String EXCHANGED_URL = "/top-exchanged";

    @Autowired
    private ItemExchangedImpl exchangedImpl;

    @PostMapping()
    @Operation(summary = "Endpoint to list top 5 exchanged items")
    public ResponseEntity<Map<String,Object>> topItems (@RequestBody ItemsCouponInfo itemsCouponInfo){
        Map<String, Object> response = new HashMap<>();
        String message = "";
        exchangedImpl.findTopFive(itemsCouponInfo.getItems_ids());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

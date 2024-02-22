package com.freecupon.MELI.domain.controllers;

import com.freecupon.MELI.domain.dto.ItemsCouponInfo;
import com.freecupon.MELI.domain.services.coupon.impl.CouponImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = CouponController.CUPON_URL)
@Tag(name = "CouponRest")
public class CouponController {

    public static final String CUPON_URL = "/cupon";

    @Autowired
    private CouponImpl couponImpl;

    @PostMapping()
    @Operation(summary = "Endpoint to find the max use of the coupon")
    public ResponseEntity<ItemsCouponInfo> maximizeCoupon (@RequestBody ItemsCouponInfo itemsCouponInfo){
        ItemsCouponInfo response = couponImpl.maximizeCoupon(itemsCouponInfo);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}

package com.freecupon.MELI.domain.services.coupon;

import com.freecupon.MELI.domain.dto.ItemsCouponInfo;

import java.util.List;
public interface CouponService {
    ItemsCouponInfo maximizeCoupon(ItemsCouponInfo cuponInfo);
}

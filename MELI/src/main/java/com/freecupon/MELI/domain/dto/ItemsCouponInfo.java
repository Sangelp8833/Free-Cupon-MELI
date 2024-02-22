package com.freecupon.MELI.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ItemsCouponInfo {

    private List<String> items_ids;
    private Double amount;

}

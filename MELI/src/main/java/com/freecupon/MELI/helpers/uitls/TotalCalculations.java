package com.freecupon.MELI.helpers.uitls;

import java.util.List;

public class TotalCalculations {

    public int total(Integer qOfElements, Integer cuponValue, List<Integer> prices){
        if(qOfElements <= 0){
            return 0;
        }else if(prices.get(qOfElements - 1) > cuponValue){
            return total(qOfElements - 1, cuponValue, prices);
        }else{
            return Math.max(prices.get(qOfElements - 1) + total(qOfElements  - 1,
                    cuponValue - prices.get(qOfElements - 1),prices), total(qOfElements - 1,
                    cuponValue,prices));
        }
    }

}

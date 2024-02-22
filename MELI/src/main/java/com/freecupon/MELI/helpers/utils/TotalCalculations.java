package com.freecupon.MELI.helpers.utils;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TotalCalculations {

    public double total(Integer qOfElements, Double cuponValue, List<Integer> prices, int[] visited){
        if(qOfElements <= 0){
            return 0;
        }else if(prices.get(qOfElements - 1) > cuponValue){
            return total(qOfElements - 1, cuponValue, prices, visited);
        }else{

            int[] considerIds = new int[visited.length];
            System.arraycopy(visited, 0, considerIds, 0, visited.length);
            int[] notConsiderIds = new int[visited.length];
            System.arraycopy(visited, 0, notConsiderIds, 0, visited.length);
            considerIds[qOfElements - 1] = 1;

            double consider = prices.get(qOfElements - 1) + total(qOfElements  - 1,
                    cuponValue - prices.get(qOfElements - 1),prices, considerIds);
            double notConsider = total(qOfElements - 1, cuponValue,prices, notConsiderIds);

            if(consider > notConsider){
               System.arraycopy(considerIds,0,visited,0,considerIds.length);
            }else{
                System.arraycopy(notConsiderIds,0,visited,0,notConsiderIds.length);
            }

            return Math.max(consider,notConsider);
        }
    }

}

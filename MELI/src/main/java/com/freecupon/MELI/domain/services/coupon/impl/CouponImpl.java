package com.freecupon.MELI.domain.services.coupon.impl;

import com.freecupon.MELI.domain.dto.ItemsCouponInfo;
import com.freecupon.MELI.domain.services.coupon.CouponService;
import com.freecupon.MELI.helpers.utils.TotalCalculations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class CouponImpl implements CouponService {

    @Autowired
    private TotalCalculations couponUse;

    @Override
    public ItemsCouponInfo maximizeCoupon(ItemsCouponInfo cuponInfo) {

        List<String> items_ids = extractUnique(cuponInfo.getItems_ids());
        int[] visited = new int[items_ids.size()];
        Integer qOfElements = items_ids.size();
        Double couponValue = cuponInfo.getAmount();

        List<Integer> prices = new ArrayList<>(); //Consumir el API para los precios
        prices.add(100);
        prices.add(210);
        prices.add(260);
        prices.add(80);
        prices.add(90);

        ItemsCouponInfo couponInfo = new ItemsCouponInfo();
        double total = couponUse.total(qOfElements,couponValue,prices,visited);
        couponInfo.setAmount(total);
        couponInfo.setItems_ids(extractItemsIds(visited,items_ids));
        return couponInfo;
    }

    private List<String> extractUnique(List<String> items_ids) {
        Set<String> uniqueIds = new HashSet<>(items_ids);
        return new ArrayList<>(uniqueIds);
    }

    private List<String> extractItemsIds(int[] visited, List<String> items_ids){
        List<String> itemsUsed = new ArrayList<>();
        AtomicInteger aux = new AtomicInteger(0);
        Arrays.stream(visited).boxed().collect(Collectors.toList()).forEach(e -> {
            if(e != null && e.equals(1)){
                itemsUsed.add(items_ids.get(aux.get()));
            }
            aux.getAndIncrement();
        });
        return itemsUsed;
    }
}

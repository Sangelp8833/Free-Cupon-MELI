package com.freecupon.MELI.domain.services.coupon.impl;

import com.freecupon.MELI.domain.dto.ItemsCouponInfo;
import com.freecupon.MELI.domain.services.coupon.CouponService;
import com.freecupon.MELI.helpers.utils.ItemsPrices;
import com.freecupon.MELI.helpers.utils.TotalCalculations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class CouponImpl implements CouponService {

    @Autowired
    private TotalCalculations couponUse;

    @Autowired
    private ItemsPrices itemsPrices;

    @Override
    public ItemsCouponInfo maximizeCoupon(ItemsCouponInfo cuponInfo) {

        List<String> items_ids = extractUnique(cuponInfo.getItems_ids());

        Double couponValue = cuponInfo.getAmount();
        List<Double> prices = new ArrayList<>();
        List<String> items_ids_filtered = new ArrayList<>();

        items_ids.forEach(e -> {
            try {
                Double prices_search = itemsPrices.getItemsPrice(e);
                if(prices_search != 0){
                    prices.add(prices_search);
                    items_ids_filtered.add(e);
                }
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        int[] visited = new int[items_ids_filtered.size()];
        Integer qOfElements = items_ids_filtered.size();

        ItemsCouponInfo couponInfo = new ItemsCouponInfo();
        double total = couponUse.total(qOfElements,couponValue,prices,visited);
        couponInfo.setAmount(total);
        couponInfo.setItems_ids(extractItemsIds(visited,items_ids_filtered));
        return couponInfo;
    }

    private List<String> extractUnique(List<String> items_ids_filtered) {
        Set<String> uniqueIds = new HashSet<>(items_ids_filtered);
        return new ArrayList<>(uniqueIds);
    }

    private List<String> extractItemsIds(int[] visited, List<String> items_ids_filtered){
        List<String> itemsUsed = new ArrayList<>();
        AtomicInteger aux = new AtomicInteger(0);
        Arrays.stream(visited).boxed().collect(Collectors.toList()).forEach(e -> {
            if(e != null && e.equals(1)){
                itemsUsed.add(items_ids_filtered.get(aux.get()));
            }
            aux.getAndIncrement();
        });
        return itemsUsed;
    }
}

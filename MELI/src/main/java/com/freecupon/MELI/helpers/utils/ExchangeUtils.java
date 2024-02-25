package com.freecupon.MELI.helpers.utils;

import com.freecupon.MELI.domain.dto.ItemsExchangedDto;
import com.freecupon.MELI.domain.services.exchanged.impl.ItemExchangedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeUtils {

    @Autowired
    private ItemExchangedImpl exchangedImpl;

    @Async
    public void updateExchaged(List<String> items_ids){
        items_ids.forEach(e -> exchangedImpl.updateItemExchanged(e));
    }


}

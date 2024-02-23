package com.freecupon.MELI.domain.services.exchanged;

import com.freecupon.MELI.domain.dto.ItemsExchangedDto;

import java.util.Map;

public interface ItemsExchangedService {

    ItemsExchangedDto saveItem(ItemsExchangedDto itemsExchangedDto);
    boolean updateItemExchanged(ItemsExchangedDto partialUpdate, String itemId);
    ItemsExchangedDto findByItemId(String itemId);

}

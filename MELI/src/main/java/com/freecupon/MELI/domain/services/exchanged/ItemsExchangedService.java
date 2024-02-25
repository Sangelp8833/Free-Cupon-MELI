package com.freecupon.MELI.domain.services.exchanged;

import com.freecupon.MELI.domain.dto.ItemsExchangedDto;

import java.util.List;


public interface ItemsExchangedService {

    ItemsExchangedDto saveItem(ItemsExchangedDto itemsExchangedDto);
    boolean updateItemExchanged(String itemId);
    ItemsExchangedDto findByItemId(String itemId);
    List<ItemsExchangedDto> findTopFive(List<String> itemsId);
}

package com.freecupon.MELI.domain.services.exchanged.impl;

import com.freecupon.MELI.domain.dto.ItemsExchangedDto;
import com.freecupon.MELI.domain.models.ItemsExchanged;
import com.freecupon.MELI.domain.services.exchanged.ItemsExchangedService;
import com.freecupon.MELI.repository.ItemsExchangedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemExchangedImpl implements ItemsExchangedService {


    @Autowired
    private ItemsExchangedRepository itemsExchangedRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemsExchangedDto saveItem(ItemsExchangedDto itemsExchangedDto) {

        ItemsExchanged itemsExc = modelMapper.map(itemsExchangedDto, ItemsExchanged.class);
        return modelMapper.map(itemsExchangedRepository.save(itemsExc),ItemsExchangedDto.class);

    }

    @Override
    public boolean updateItemExchanged(ItemsExchangedDto partialUpdate, String itemId) {
        ItemsExchanged itemExc = itemsExchangedRepository.findByItemId(itemId);
        if(itemExc == null){
            ItemsExchangedDto itemSaved = saveItem(partialUpdate);
            return itemSaved != null;
        }else {
            itemExc.setExchanged(partialUpdate.getExchanged());
            itemsExchangedRepository.save(itemExc);
            return true;
        }
    }

    @Override
    public ItemsExchangedDto findByItemId(String itemId) {
        ItemsExchanged itemExc = itemsExchangedRepository.findByItemId(itemId);
        if(itemExc != null){
            return modelMapper.map(itemExc,ItemsExchangedDto.class);
        }
        return null;
    }
}

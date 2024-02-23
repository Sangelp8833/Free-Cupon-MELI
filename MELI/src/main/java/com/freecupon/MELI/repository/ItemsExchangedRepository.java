package com.freecupon.MELI.repository;

import com.freecupon.MELI.domain.models.ItemsExchanged;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsExchangedRepository extends JpaRepository<ItemsExchanged,Long> {

    ItemsExchanged findByItemId(String itemId);

}

package com.freecupon.MELI.repository;

import com.freecupon.MELI.domain.models.ItemsExchanged;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemsExchangedRepository extends JpaRepository<ItemsExchanged,Long> {

    ItemsExchanged findByItemId(String itemId);

    @Transactional
    @Query(value = "SELECT i FROM ItemsExchanged " +
            "WHERE i.itemId IN :listItems " +
            "ORDER BY i.exchanged DESC " +
            "FETCH FIRST 5 ROWS ONLY")
    List<ItemsExchanged> findTopFive(@Param("listItems") List<String> itemsId);

}

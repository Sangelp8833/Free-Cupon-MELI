package com.freecupon.MELI.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exchanged")
public class ItemsExchanged {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long table_id;

    @NotNull(message = "Se debe asignar un item_id")
    @Column(name = "item_id")
    private String itemId;

    @Column(name = "exchanged")
    private Long exchanged;

}

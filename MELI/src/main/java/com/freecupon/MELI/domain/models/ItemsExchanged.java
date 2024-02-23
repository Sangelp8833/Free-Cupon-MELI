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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Se debe asignar un item_id")
    @Column(name = "item_id")
    private String item_id;

    @Column(name = "exchanged")
    private Integer exchanged;

}

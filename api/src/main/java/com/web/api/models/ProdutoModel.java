package com.web.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nomeProduto;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusVendaEnum statusVenda;
}

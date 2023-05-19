package com.web.api.models;

import com.web.api.enuns.StatusVendaEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nomeProduto;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusVendaEnum statusVenda;
}

package com.web.api.dtos;

import com.web.api.enuns.StatusVendaEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record ProdutoDto(
        @NotBlank(message = "O nome do produto não pode estar vazio.")
        @Size(min = 3, max = 255, message = "O nome do produto deve ter entre 3 a 255 caracteres.")
        String nomeProduto,

        @NotBlank(message = "A descrição do produto não pode estar vazia.")
        @Size(min = 3, max = 255, message = "A descrição do produto deve ter entre 3 a 255 caracteres.")
        String descricao,
        @NotBlank(message = "O status da venda não pode ser nulo.")
        StatusVendaEnum statusVenda
) {
}

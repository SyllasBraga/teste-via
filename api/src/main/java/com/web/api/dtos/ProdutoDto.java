package com.web.api.dtos;

import com.web.api.enuns.StatusVendaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ProdutoDto {

    @NotBlank(message = "O nome do produto não pode estar vazio.")
    @Size(min = 3, max = 255, message = "O nome do produto deve ter entre 3 a 255 caracteres.")
     private String nomeProduto;

    @NotBlank(message = "A descrição do produto não pode estar vazia.")
    @Size(min = 3, max = 255, message = "A descrição do produto deve ter entre 3 a 255 caracteres.")
    private String descricao;

    private StatusVendaEnum statusVenda;
}

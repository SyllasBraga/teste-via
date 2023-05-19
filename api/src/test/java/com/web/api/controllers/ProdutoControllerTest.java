package com.web.api.controllers;

import com.web.api.dtos.ProdutoDto;
import com.web.api.enuns.StatusVendaEnum;
import com.web.api.services.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;

public class ProdutoControllerTest {

    private static final String nomeProduto = "Feijão";
    private static final String descricao = "Pacote de 20KG";
    private static final StatusVendaEnum statusVenda = StatusVendaEnum.VENDIDO;

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    ProdutoDto produtoDto;
    List<ProdutoDto> listaProdutosDto;

    @BeforeEach
    private void setUp(){
        MockitoAnnotations.openMocks(this);
        startObjets();
    }

    @Test
    @DisplayName("Teste: ProdutoService.createByListProdutos()")
    public void quandoCreateByListRetornaUmHttpCodeCreated(){
        Mockito.when(produtoService.createByListProdutos(anyList())).thenReturn(listaProdutosDto);

        ResponseEntity<List<ProdutoDto>> response = produtoController.createByList(listaProdutosDto);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    private void startObjets(){
        produtoDto = new ProdutoDto(nomeProduto, descricao, statusVenda);
        listaProdutosDto = List.of(produtoDto);
    }
}

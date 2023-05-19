package com.web.api.services;

import com.web.api.dtos.ProdutoDto;
import com.web.api.enuns.StatusVendaEnum;
import com.web.api.models.ProdutoModel;
import com.web.api.repositories.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class ProdutoServiceTests {

    private static final String nomeProduto = "Feijão";
    private static final String descricao = "Pacote de 20KG";
    private static final StatusVendaEnum statusVenda = StatusVendaEnum.VENDIDO;

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Spy
    private ModelMapper modelMapper;

    ProdutoDto produtoDto;
    private ProdutoModel produtoModel;
    private List<ProdutoModel> listaProdutosModel;
    private List<ProdutoDto> listaProdutosDto;

    @BeforeEach
    private void setUp(){
        MockitoAnnotations.openMocks(this);
        startObjets();
    }

    @Test
    @DisplayName("Teste: ProdutoService.createByListProdutos()")
    public void quandoCreateByListProdutosRetornaUmaListaProdutos(){

        Mockito.when(produtoRepository.saveAll(any())).thenReturn(listaProdutosModel);

        List<ProdutoDto> resultado = produtoService.createByListProdutos(listaProdutosDto);

        Assertions.assertEquals(ProdutoDto.class, resultado.get(0).getClass());
    }

    private void startObjets() {
        produtoDto = new ProdutoDto(nomeProduto, descricao, statusVenda);
        produtoModel = new ProdutoModel(null, nomeProduto, descricao, statusVenda);
        listaProdutosDto = List.of(produtoDto);
        listaProdutosModel = List.of(produtoModel);
    }
}

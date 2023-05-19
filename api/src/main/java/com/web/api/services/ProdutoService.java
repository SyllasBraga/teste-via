package com.web.api.services;

import com.web.api.dtos.ProdutoDto;
import com.web.api.models.ProdutoModel;
import com.web.api.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    public void createByListProdutos(List<ProdutoDto> listaProdutosDto){

        List<ProdutoModel> listaProdutosParaSalvar = converterParaListaProdutosModel(listaProdutosDto);

        produtoRepository.saveAll(listaProdutosParaSalvar);
    }

    private List<ProdutoModel> converterParaListaProdutosModel (List<ProdutoDto> listaDto){
        List<ProdutoModel> listaProdutos = new ArrayList<>();

        listaDto.forEach(produtoDto -> listaProdutos.add(converterParaProdutoModel(produtoDto)));

        return listaProdutos;
    }

    private ProdutoModel converterParaProdutoModel(ProdutoDto listaProdutosDto){
        return modelMapper.map(listaProdutosDto, ProdutoModel.class);
    }
}


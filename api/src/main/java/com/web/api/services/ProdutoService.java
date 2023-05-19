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

    public List<ProdutoDto> createByListProdutos(List<ProdutoDto> listaProdutosDto){

        List<ProdutoModel> listaProdutosParaSalvar = converterParaListaProdutosModel(listaProdutosDto);

        List<ProdutoModel> listaAtualizada = produtoRepository.saveAll(listaProdutosParaSalvar);

        return converterParaListaProdutosDto(listaAtualizada);
    }

    private List<ProdutoModel> converterParaListaProdutosModel (List<ProdutoDto> listaDto){
        List<ProdutoModel> listaProdutos = new ArrayList<>();

        listaDto.forEach(produtoDto -> listaProdutos.add(converterParaProdutoModel(produtoDto)));

        return listaProdutos;
    }

    private ProdutoModel converterParaProdutoModel(ProdutoDto produtosDto){
        return modelMapper.map(produtosDto, ProdutoModel.class);
    }

    private List<ProdutoDto> converterParaListaProdutosDto (List<ProdutoModel> listaModel){
        List<ProdutoDto> listaProdutos = new ArrayList<>();

        listaModel.forEach(produtoModel -> listaProdutos.add(converterParaProdutoDto(produtoModel)));

        return listaProdutos;
    }

    private ProdutoDto converterParaProdutoDto(ProdutoModel produtoModel){
        return modelMapper.map(produtoModel, ProdutoDto.class);
    }
}


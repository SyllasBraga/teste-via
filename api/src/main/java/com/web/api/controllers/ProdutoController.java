package com.web.api.controllers;

import com.web.api.dtos.ProdutoDto;
import com.web.api.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@Validated
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<List<ProdutoDto>> createByList(@RequestBody @Valid List<ProdutoDto> listaProdutoDto){
        List<ProdutoDto> listaProdutoSalva = produtoService.createByListProdutos(listaProdutoDto);
        return ResponseEntity.status(201).body(listaProdutoSalva);
    }
}

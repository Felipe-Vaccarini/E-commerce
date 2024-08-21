package io.github.felipevaccarini.ecommerce.api.controller;

import io.github.felipevaccarini.ecommerce.api.dto.ProdutoDTO;
import io.github.felipevaccarini.ecommerce.domain.entity.Categoria;
import io.github.felipevaccarini.ecommerce.domain.entity.Produto;
import io.github.felipevaccarini.ecommerce.service.impl.CategoriaService;
import io.github.felipevaccarini.ecommerce.service.impl.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> obterTodosProdutos() {
        List<Produto> produtos = produtoService.findAll();
        List<ProdutoDTO> produtosDTO = produtos.stream()
                .map(ProdutoDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(produtosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> obterProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return produto.map(value -> ResponseEntity.ok(ProdutoDTO.fromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Optional<Categoria> categoria = categoriaService.findById(produtoDTO.getCategoriaId());
        if (categoria.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Produto produto = ProdutoDTO.toEntity(produtoDTO, categoria.get());
        Produto produtoSalvo = produtoService.save(produto);
        ProdutoDTO produtoSalvoDTO = ProdutoDTO.fromEntity(produtoSalvo);
        return ResponseEntity.ok(produtoSalvoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Optional<Produto> produtoExistente = produtoService.findById(id);
        if (produtoExistente.isPresent()) {
            Optional<Categoria> categoria = categoriaService.findById(produtoDTO.getCategoriaId());
            if (categoria.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            Produto produto = ProdutoDTO.toEntity(produtoDTO, categoria.get());
            produto.setId(id);
            Produto produtoAtualizado = produtoService.save(produto);
            return ResponseEntity.ok(ProdutoDTO.fromEntity(produtoAtualizado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        if (produtoService.findById(id).isPresent()) {
            produtoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

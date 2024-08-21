package io.github.felipevaccarini.ecommerce.api.controller;

import io.github.felipevaccarini.ecommerce.api.dto.CategoriaDTO;
import io.github.felipevaccarini.ecommerce.domain.entity.Categoria;
import io.github.felipevaccarini.ecommerce.service.impl.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> obterTodasCategorias() {
        List<Categoria> categorias = categoriaService.findAll();
        List<CategoriaDTO> categoriasDTO = categorias.stream()
                .map(CategoriaDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categoriasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obterCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        return categoria.map(value -> ResponseEntity.ok(CategoriaDTO.fromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = CategoriaDTO.toEntity(categoriaDTO);
        Categoria categoriaSalva = categoriaService.save(categoria);
        CategoriaDTO categoriaSalvaDTO = CategoriaDTO.fromEntity(categoriaSalva);
        return ResponseEntity.ok(categoriaSalvaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaExistente = categoriaService.findById(id);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = CategoriaDTO.toEntity(categoriaDTO);
            categoria.setId(id);
            Categoria categoriaAtualizada = categoriaService.save(categoria);
            return ResponseEntity.ok(CategoriaDTO.fromEntity(categoriaAtualizada));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        if (categoriaService.findById(id).isPresent()) {
            categoriaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

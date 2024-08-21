package io.github.felipevaccarini.ecommerce.api.dto;

import io.github.felipevaccarini.ecommerce.domain.entity.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    public static CategoriaDTO fromEntity(Categoria categoria) {
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNome()
        );
    }

    public static Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNome(dto.getNome());
        return categoria;
    }
}

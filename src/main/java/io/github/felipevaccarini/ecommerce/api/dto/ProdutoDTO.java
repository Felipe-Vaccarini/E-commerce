package io.github.felipevaccarini.ecommerce.api.dto;

import io.github.felipevaccarini.ecommerce.domain.entity.Categoria;
import io.github.felipevaccarini.ecommerce.domain.entity.Produto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Size(max = 255)
    private String descricao;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal preco;

    @NotNull
    @PositiveOrZero
    private Integer estoque;

    @NotNull
    private Long categoriaId;

    public static ProdutoDTO fromEntity(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getCategoria().getId()
        );
    }

    public static Produto toEntity(ProdutoDTO dto, Categoria categoria) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        produto.setCategoria(categoria);
        return produto;
    }
}

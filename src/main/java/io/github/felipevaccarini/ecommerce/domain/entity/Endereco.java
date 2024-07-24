package io.github.felipevaccarini.ecommerce.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "rua", length = 100, nullable = false)
    private String rua;

    @NotNull
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Size(max = 50)
    @Column(name = "complemento", length = 50)
    private String complemento;

    @NotBlank
    @Size(max = 50)
    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @NotBlank
    @Size(max = 50)
    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;

    @NotBlank
    @Size(max = 50)
    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @NotBlank
    @Size(max = 10)
    @Pattern(regexp = "\\d{5}-\\d{3}")
    @Column(name = "cep", length = 10, nullable = false)
    private String cep;

    @NotBlank
    @Size(max = 50)
    @Column(name = "pais", length = 50, nullable = false)
    private String pais;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}

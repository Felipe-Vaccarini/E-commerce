package io.github.felipevaccarini.ecommerce.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @NotBlank
    @Size(max = 30)
    @Column(name = "metodo", length = 30, nullable = false)
    private String metodo;

    @NotNull
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @NotNull
    @Column(name = "dataPagamento", nullable = false)
    private LocalDateTime dataPagamento;
}

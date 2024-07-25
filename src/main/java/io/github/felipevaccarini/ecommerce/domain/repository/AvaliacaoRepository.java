package io.github.felipevaccarini.ecommerce.domain.repository;

import io.github.felipevaccarini.ecommerce.domain.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}

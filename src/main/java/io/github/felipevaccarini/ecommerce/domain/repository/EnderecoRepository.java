package io.github.felipevaccarini.ecommerce.domain.repository;

import io.github.felipevaccarini.ecommerce.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

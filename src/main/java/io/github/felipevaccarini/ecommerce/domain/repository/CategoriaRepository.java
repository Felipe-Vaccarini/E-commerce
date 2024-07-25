package io.github.felipevaccarini.ecommerce.domain.repository;

import io.github.felipevaccarini.ecommerce.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

package io.github.felipevaccarini.ecommerce.domain.repository;

import io.github.felipevaccarini.ecommerce.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

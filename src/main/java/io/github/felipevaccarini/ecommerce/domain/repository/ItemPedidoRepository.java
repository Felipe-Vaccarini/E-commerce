package io.github.felipevaccarini.ecommerce.domain.repository;

import io.github.felipevaccarini.ecommerce.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}

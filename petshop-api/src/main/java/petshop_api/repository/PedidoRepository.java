package petshop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petshop_api.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

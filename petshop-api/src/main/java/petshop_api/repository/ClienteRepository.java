package petshop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petshop_api.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

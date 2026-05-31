package petshop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petshop_api.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

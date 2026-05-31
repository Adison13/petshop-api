package petshop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petshop_api.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

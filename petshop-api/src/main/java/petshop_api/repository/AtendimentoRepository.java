package petshop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petshop_api.entity.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}

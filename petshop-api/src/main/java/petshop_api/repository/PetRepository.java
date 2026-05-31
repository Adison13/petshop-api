package petshop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petshop_api.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}

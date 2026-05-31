package petshop_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshop_api.entity.Pet;
import petshop_api.repository.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<Pet> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pet> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Pet salvar(Pet pet) {
        return repository.save(pet);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
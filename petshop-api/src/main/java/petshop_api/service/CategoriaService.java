package petshop_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshop_api.entity.Categoria;
import petshop_api.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listarTodos() { return repository.findAll(); }
    public Optional<Categoria> buscarPorId(Long id) { return repository.findById(id); }
    public Categoria salvar(Categoria categoria) { return repository.save(categoria); }
    public void deletar(Long id) { repository.deleteById(id); }
}

package petshop_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshop_api.entity.Atendimento;
import petshop_api.repository.AtendimentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    public List<Atendimento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Atendimento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Atendimento salvar(Atendimento atendimento) {
        return repository.save(atendimento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
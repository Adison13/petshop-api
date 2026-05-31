package petshop_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshop_api.entity.Atendimento;
import petshop_api.service.AtendimentoService;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService service;

    @GetMapping
    public List<Atendimento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Atendimento salvar(@RequestBody Atendimento atendimento) {
        return service.salvar(atendimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> atualizar(@PathVariable Long id, @RequestBody Atendimento atendimento) {
        return service.buscarPorId(id)
                .map(existente -> {
                    atendimento.setId(id);
                    return ResponseEntity.ok(service.salvar(atendimento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

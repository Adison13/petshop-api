package petshop_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshop_api.entity.Produto;
import petshop_api.service.ProdutoService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto salvar(@RequestBody @Valid Produto produto) {
        return service.salvar(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody @Valid Produto produto) {
        return service.buscarPorId(id)
                .map(existente -> {
                    produto.setId(id);
                    return ResponseEntity.ok(service.salvar(produto));
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
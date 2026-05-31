package petshop_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshop_api.entity.Categoria;
import petshop_api.service.CategoriaService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria salvar(@RequestBody @Valid Categoria categoria) {
        return service.salvar(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody @Valid Categoria categoria) {
        return service.buscarPorId(id)
                .map(existente -> {
                    categoria.setId(id);
                    return ResponseEntity.ok(service.salvar(categoria));
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

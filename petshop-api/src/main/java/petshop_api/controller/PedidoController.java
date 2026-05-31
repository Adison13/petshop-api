package petshop_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshop_api.entity.Pedido;
import petshop_api.service.PedidoService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido salvar(@RequestBody @Valid Pedido pedido) {
        return service.salvar(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody @Valid Pedido pedido) {
        return service.buscarPorId(id)
                .map(existente -> {
                    pedido.setId(id);
                    return ResponseEntity.ok(service.salvar(pedido));
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

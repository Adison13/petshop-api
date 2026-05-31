package petshop_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshop_api.entity.Pet;
import petshop_api.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public List<Pet> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pet salvar(@RequestBody Pet pet) {
        return service.salvar(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizar(@PathVariable Long id, @RequestBody Pet pet) {
        return service.buscarPorId(id)
                .map(existente -> {
                    pet.setId(id);
                    return ResponseEntity.ok(service.salvar(pet));
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

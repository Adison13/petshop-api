package petshop_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshop_api.entity.Pedido;
import petshop_api.repository.PedidoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> listarTodos() { return repository.findAll(); }
    public Optional<Pedido> buscarPorId(Long id) { return repository.findById(id); }

    public Pedido salvar(Pedido pedido) {
        if (pedido.getData() == null) {
            pedido.setData(LocalDate.now());
        }
        if (pedido.getStatus() == null) {
            pedido.setStatus("PENDENTE");
        }
        if (pedido.getItens() != null) {
            pedido.getItens().forEach(item -> {
                item.setPedido(pedido);
                item.setPrecoUnitario(item.getProduto().getPreco());
            });
            BigDecimal total = pedido.getItens().stream()
                    .map(i -> i.getPrecoUnitario().multiply(BigDecimal.valueOf(i.getQuantidade())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            pedido.setTotal(total);
        }
        return repository.save(pedido);
    }

    public void deletar(Long id) { repository.deleteById(id); }
}
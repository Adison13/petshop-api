package petshop_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private String status;

    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties("pedidos")
    @NotNull(message = "Cliente é obrigatório")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("pedido")
    private List<ItemPedido> itens;

    public Pedido() {}

    public Long getId() { return id; }
    public LocalDate getData() { return data; }
    public String getStatus() { return status; }
    public BigDecimal getTotal() { return total; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }

    public void setId(Long id) { this.id = id; }
    public void setData(LocalDate data) { this.data = data; }
    public void setStatus(String status) { this.status = status; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setItens(List<ItemPedido> itens) { this.itens = itens; }
}

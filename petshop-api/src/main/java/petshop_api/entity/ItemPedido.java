package petshop_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    private BigDecimal precoUnitario;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnoreProperties("itens")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonIgnoreProperties("itens")
    private Produto produto;

    public ItemPedido() {}

    public Long getId() { return id; }
    public Integer getQuantidade() { return quantidade; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public Pedido getPedido() { return pedido; }
    public Produto getProduto() { return produto; }

    public void setId(Long id) { this.id = id; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public void setProduto(Produto produto) { this.produto = produto; }
}

package petshop_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("categoria")
    private List<Produto> produtos;

    public Categoria() {}

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public List<Produto> getProdutos() { return produtos; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}

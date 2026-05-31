package petshop_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie;
    private String raca;
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties("pets")
    private Cliente cliente;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("pet")
    private List<Atendimento> atendimentos;

    public Pet() {}

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    public String getRaca() { return raca; }
    public Integer getIdade() { return idade; }
    public Cliente getCliente() { return cliente; }
    public List<Atendimento> getAtendimentos() { return atendimentos; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEspecie(String especie) { this.especie = especie; }
    public void setRaca(String raca) { this.raca = raca; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setAtendimentos(List<Atendimento> atendimentos) { this.atendimentos = atendimentos; }
}

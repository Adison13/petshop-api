package petshop_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String telefone;

    @Email(message = "Email inválido")
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<Pet> pets;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<Pedido> pedidos;

    public Cliente() {}

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public List<Pet> getPets() { return pets; }
    public List<Pedido> getPedidos() { return pedidos; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEmail(String email) { this.email = email; }
    public void setPets(List<Pet> pets) { this.pets = pets; }
    public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }
}

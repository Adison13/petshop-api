package petshop_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "atendimentos")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String servico;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonIgnoreProperties("atendimentos")
    private Pet pet;

    public Atendimento() {}

    public Long getId() { return id; }
    public String getServico() { return servico; }
    public LocalDate getData() { return data; }
    public Pet getPet() { return pet; }

    public void setId(Long id) { this.id = id; }
    public void setServico(String servico) { this.servico = servico; }
    public void setData(LocalDate data) { this.data = data; }
    public void setPet(Pet pet) { this.pet = pet; }
}


package domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    @OneToMany(mappedBy = "categoria")
    private List<Servico> servicos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    
    public void addServico(Servico servico){
        this.servicos.add(servico);
        servico.setCategoria(this);
    }
}

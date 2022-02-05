
package domain;

import java.util.*;
import javax.persistence.*;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Embedded
    private Endereco endereco;
    private String email;
    @ElementCollection
    List<Telefone> telefones = new ArrayList<>();
    @Temporal (TemporalType.DATE)
    private Calendar dataNascimento;
    private boolean ativo;

    public Cliente() {
    }

    public Cliente(String nome, String email, Calendar dataNascimento, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
        
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    public void addTelefone(Telefone telefone){
        this.telefones.add(telefone);
    }
}

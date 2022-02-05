
package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
public class Profissional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    @Temporal (TemporalType.DATE)
    private Calendar dataNascimento;
    @Temporal (TemporalType.DATE)
    private Calendar admissao;
    private String cargo;
    private double salario;
    @Embedded
    private Endereco endereco;
    @ElementCollection
    List<Telefone> telefones = new ArrayList<>();
    private String email;
    private boolean ativo;
       
    
    public Profissional() {
    }

    public Profissional(String nome, String rg, String cpf, Calendar dataNascimento, Calendar admissao, String cargo, double salario, String email, boolean ativo) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.admissao = admissao;
        this.cargo = cargo;
        this.salario = salario;
        this.email = email;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Calendar getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Calendar admissao) {
        this.admissao = admissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void addTelefone(Telefone telefone){
        this.telefones.add(telefone);
    }
    
}


package domain;

import java.util.*;
import javax.persistence.*;

@Entity
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Cliente cliente;
    private String formaPagamento; 
    @ManyToOne
    @JoinColumn(name="CAIXA_ID")
    private Caixa caixa; 
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar dataHora;
    @OneToMany(mappedBy = "venda")
    private List<Item> itens = new ArrayList<>();
    
    public Venda() {
    }

    public Venda(Calendar dataHora, String formaPagamento) {
        this.dataHora = dataHora;
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    
    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    public void addItem(Item item){
        this.itens.add(item);
        item.setVenda(this);
    }
}

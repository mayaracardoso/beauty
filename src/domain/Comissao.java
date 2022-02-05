
package domain;

import javax.persistence.*;

@Entity
public class Comissao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Item item;
    @OneToOne
    private Profissional profissional;
    private double valorComissao;

    public Comissao() {
    }

    public Comissao(double valorComissao) {
        this.valorComissao = valorComissao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public double getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(double valorComissao) {
        this.valorComissao = valorComissao;
    }
    
    public double calculaComissao(){
        valorComissao = (item.getValor() * item.getQuantidade()) * 0.10;
        return valorComissao;
    }
    
}

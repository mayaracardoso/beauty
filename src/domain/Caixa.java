
package domain;

import java.util.*;
import javax.persistence.*;

@Entity
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar dataHoraAbertura;
    private double valorInicial;
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar dataHoraFechamento; 
    private boolean aberto;
    @OneToMany(mappedBy = "caixa")
    private  List<Venda> vendas = new ArrayList<>();

    public Caixa() {
    }

    public Caixa(Calendar dataHoraAbertura, double valorInicial, Calendar dataHoraFechamento, boolean aberto) {
        this.dataHoraAbertura = dataHoraAbertura;
        this.valorInicial = valorInicial;
        this.dataHoraFechamento = dataHoraFechamento;
        this.aberto = aberto;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Calendar dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Calendar getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Calendar dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    public void addVenda(Venda venda){
        this.vendas.add(venda);
        venda.setCaixa(this);
    }
}

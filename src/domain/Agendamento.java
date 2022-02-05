
package domain;


import java.util.Calendar;
import javax.persistence.*;

@Entity
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="CLIENTE_ID")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="PROFISSIONAL_ID")
    private Profissional profissional;
    @ManyToOne
    @JoinColumn(name="SERVICO_ID")
    private Servico servico;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataHorario;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAgendamento;
    private String observacoes;

    public Agendamento() {
    }

    public Agendamento(Calendar dataHorario, String observacoes, Calendar dataAgendamento) {
        this.dataHorario = dataHorario;
        this.observacoes = observacoes;
        this.dataAgendamento = dataAgendamento;
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

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Calendar getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Calendar dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Calendar getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Calendar dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
    
    
}

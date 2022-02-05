

package beauty;

import domain.*;
import java.util.Calendar;
import javax.persistence.*;


public class Beauty {

    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BeautyPU");
        EntityManager em = emf.createEntityManager();
        
        Calendar c = Calendar.getInstance();
        c.set(1991, 4, 12);
       
        Calendar c1 = Calendar.getInstance();
        c1.set(1954, 9, 22);
        
        Calendar c2 = Calendar.getInstance();
        c2.set(1983, 3, 27);
        
        Calendar c3 = Calendar.getInstance();
        c3.set(2015, 4, 28);
        
        Calendar c4 = Calendar.getInstance();
        c3.set(1987, 10, 21);
        
        Calendar c5 = Calendar.getInstance();
        c4.set(2014, 8, 8);
        
        Calendar c6 = Calendar.getInstance();
        c6.set(2016, 8, 17, 11, 00);
        
        Calendar c7 = Calendar.getInstance();
        c7.getTimeInMillis();
        
        Calendar c8 = Calendar.getInstance();
        c8.getTimeInMillis();
        
        Endereco e = new Endereco("39980-000", "Rua A", "10", "AP","Reis", "São Paulo", "SP"); 
        Endereco e1 = new Endereco("36985-012", "Rua Clovis", "254", null, "Pajeú", "São Paulo", "SP");
        Endereco e2 = new Endereco("12345-678", "Avenida Elvis", "333", "AP 25", "Jardim Ásia", "São Paulo", "SP"); 
        Endereco e3 = new Endereco ("02587-000", "Travessa Salinas", "44", null, "Bons Ventos", "São Paulo", "SP"); 
        Endereco e4 = new Endereco("09848-090", "Rua Tupi", "223", null, "Bela Vista", "São Paulo", "SP");
        
        Telefone t = new Telefone("11", "96111111");  
        Telefone t1 = new Telefone("11", "85632552"); 
        Telefone t2 = new Telefone ("11", "888891977"); 
        Telefone t3 = new Telefone ("11", "998876556");     
       
                        
        Cliente cliente1 = new Cliente("Mayara", "mayarakardoso@gmail.com", c, true);
        Cliente cliente2 = new Cliente("João","joao@gmail.com", c1, true);
                        
        cliente1.setEndereco(e1);
        cliente2.setEndereco(e);
        cliente1.addTelefone(t);
        cliente2.addTelefone(t);
        cliente2.addTelefone(t1);
       
       
        Servico s = new Servico("Corte", 30.0, true);
        Servico s1 = new Servico("Mão", 20.0, true);
        Servico s2 = new Servico("Drenagem linfática", 200.0, true);
        
        Categoria cat = new Categoria ("Cabelo");
        Categoria cat1 = new Categoria("Manicure");
        Categoria cat2 = new Categoria("Esteticista");
              
        cat.addServico(s);
        cat1.addServico(s1);
        cat2.addServico(s2);
       
        
        Profissional p = new Profissional("Márcia", "33.985.517-2", "968.759.845-63", c2, c3, "cabeleireira", 1500, "marcia@gmail.com", true);
        Profissional p1 = new Profissional("Júlia", "47.235.960-7", "087.856.937.85", c4, c5, "manicure", 1500, "julia@gmail.com", true);
          
        p.setEndereco(e2);
        p1.setEndereco(e3);
        p.addTelefone(t3);
        p1.addTelefone(t3);
        
        
        Agendamento ag = new Agendamento(c6, null, c7);
        Agendamento ag1 = new Agendamento(c6, "cliente entrará em contato para confirmar", c7);
        
        ag.setCliente(cliente1);
        ag.setServico(s1);
        ag.setProfissional(p1);
       
        ag1.setCliente(cliente2);
        ag1.setServico(s);
        ag1.setProfissional(p);
        
        
        Caixa caixa = new Caixa(c7, 120.0, c7, false); 
              
        Venda v = new Venda(c8, "débito");
        Venda v1 = new Venda(c8, "dinheiro");
        Venda v2 = new Venda(c8, "crédito");
        
        caixa.addVenda(v);
        caixa.addVenda(v1);
        caixa.addVenda(v2);

        v.setCliente(cliente1);
        v1.setCliente(cliente2);
        v2.setCliente(cliente2);
        
        
        Item item = new Item(1);
        item.setValor(s.getPreco());
        item.setServico(s1);
        item.setProfissional(p);
        
        Item item2 = new Item(2);
        item2.setServico(s2);
        item2.setValor(s2.getPreco());
        item.setProfissional(p1);
                
        v.addItem(item);
        v.addItem(item2);
        
        Comissao comissao = new Comissao();
        comissao.setItem(item);
        comissao.setProfissional(p1);
        comissao.setValorComissao(comissao.calculaComissao());
       
        Comissao comissao2 = new Comissao();
        comissao2.setItem(item2);
        comissao2.setProfissional(p1);
        comissao2.setValorComissao(comissao2.calculaComissao());
        
        em.getTransaction().begin();
        em.persist(cliente1);
        em.persist(cliente2);
        em.persist(s);
        em.persist(s1);
        em.persist(s2);
        em.persist(cat);
        em.persist(cat1);
        em.persist(cat2);
        em.persist(p);
        em.persist(p1);
        em.persist(ag);
        em.persist(ag1);
        em.persist(caixa);
        em.persist(v);
        em.persist(v1);
        em.persist(v2);
        em.persist(item);
        em.persist(item2);
        em.persist(comissao);
        em.persist(comissao2);
        em.getTransaction().commit();
    }
    
}

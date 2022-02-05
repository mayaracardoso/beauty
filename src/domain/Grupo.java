
package domain;

import java.util.*;
import javax.persistence.*;

@Entity
public class Grupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    @OneToMany(mappedBy = "grupo")
    private List<Usuario> usuarios = new ArrayList<>();
    

    public Grupo() {
    }

    public Grupo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
}

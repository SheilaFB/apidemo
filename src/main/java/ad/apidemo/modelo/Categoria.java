package ad.apidemo.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nombre;

    //Este nome sale do que lle puxemos en Recurso, que leva un private Categoria categoría.
    @OneToMany(mappedBy = "categoria")
    private List<Recurso> recursos;

    public Categoria (){}

    public Categoria(String nombre){
        this.nombre=nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
}

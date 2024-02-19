package ad.apidemo.modelo;


import jakarta.persistence.*;

@Entity(name = "recursos")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nombre;
    String localidad;
    String web;
    float longitud;
    float latitud;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Recurso(){}

    public Recurso(String nombre, String localidad, String web, float longitud, float latitud, Categoria categoria) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.web = web;
        this.longitud = longitud;
        this.latitud = latitud;
        this.categoria = categoria;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

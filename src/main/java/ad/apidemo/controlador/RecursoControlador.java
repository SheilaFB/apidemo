package ad.apidemo.controlador;

import ad.apidemo.modelo.Recurso;
import ad.apidemo.repositorio.CategoriaRepositorio;
import ad.apidemo.repositorio.RecursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recurso")
public class RecursoControlador {

    @Autowired
    private RecursoRepositorio recursoRepositorio;
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    //todas las categorias
    @GetMapping
    public List<Recurso> obtenerRecursos(){
        return recursoRepositorio.findAll();
    }

    //Obtener una categoria por su ID
    @GetMapping("/{id}")
    public Recurso obtenerRecurso(@PathVariable long id){
        Optional<Recurso> resultado = recursoRepositorio.findById(id);
        return resultado.orElseThrow(()->
                new RuntimeException("Categoria no encontrada"));
    }

    //Alta de un recurso
    @PostMapping("/categoria/{id}")
    public Recurso crearRecurso(@PathVariable long id, @RequestBody Recurso recurso){
        //map va a coger una categoria. En nuestro recurso le vamos a decir que setCategoria, la categoria.
        Recurso rec = categoriaRepositorio.findById(id).map(categoria -> {
            recurso.setCategoria(categoria);
            return recursoRepositorio.save(recurso);
        }).orElseThrow(()->
                new RuntimeException("Categoria no encontrada"));
        return rec;
    }

    //Actualizar recurso
    @PutMapping("/{id}")
    public Recurso actualizarRecurso(@PathVariable long id, @RequestBody Recurso recurso){
        return recursoRepositorio.findById(id).map(recursoTemp -> {
            recursoTemp.setNombre((recurso.getNombre()!=null)?recurso.getNombre():recursoTemp.getNombre());
            recursoTemp.setLocalidad((recurso.getLocalidad()!=null)?recurso.getLocalidad():recursoTemp.getLocalidad());
            recursoTemp.setLatitud((recurso.getLatitud()!=0)?recurso.getLatitud():recursoTemp.getLatitud());
            recursoTemp.setLongitud((recurso.getLongitud()!=0)?recurso.getLongitud():recursoTemp.getLongitud());
            recursoTemp.setWeb((recurso.getWeb()!=null)?recurso.getWeb():recursoTemp.getWeb());
            return recursoRepositorio.save(recursoTemp);
        }).orElseThrow(()->
                new RuntimeException("Recurso no encontrado"));
    }

    //Eliminar un recurso
    @DeleteMapping("/{id}")
    public void eliminarRecurso(@PathVariable long id){
        recursoRepositorio.deleteById(id);
    }

}

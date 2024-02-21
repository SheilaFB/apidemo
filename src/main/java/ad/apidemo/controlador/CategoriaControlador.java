package ad.apidemo.controlador;

import ad.apidemo.modelo.Categoria;
import ad.apidemo.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaControlador {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    //todas las categorias
    @GetMapping
    public List<Categoria> obtenerCategorias(){
        return categoriaRepositorio.findAll();
    }

    //Obtener una categoria por su ID
    @GetMapping("/{id}")
    public Categoria obtenerCategoria(@PathVariable long id){
        Optional<Categoria> resultado = categoriaRepositorio.findById(id);
        return resultado.orElseThrow(()->
                new RuntimeException("Categoria no encontrada"));
    }

    //alta categoria
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }

    //actualizar categoria
    @PutMapping("/{id}")
    public Categoria actualizarCategoria(@PathVariable long id, @RequestBody Categoria categoria){
        return categoriaRepositorio.findById(id).map(categoriaTemp -> {
            categoriaTemp.setNombre(categoria.getNombre());
            return categoriaRepositorio.save(categoriaTemp);
        }).orElseThrow(()->
                new RuntimeException("Categoria no encontrada"));
    }

    //Eliminar categoria
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable long id){
        categoriaRepositorio.deleteById(id);
    }

}

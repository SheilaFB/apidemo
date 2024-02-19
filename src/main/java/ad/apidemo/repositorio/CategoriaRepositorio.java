package ad.apidemo.repositorio;

import ad.apidemo.modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

//CrudRepository espera dúas cousas, que é(neste caso Repositorio), e o tipo de dato do id (neste caso un Long)
public interface CategoriaRepositorio extends CrudRepository<Categoria,Long> {
}

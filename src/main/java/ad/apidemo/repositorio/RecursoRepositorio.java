package ad.apidemo.repositorio;

import ad.apidemo.modelo.Recurso;
import org.springframework.data.repository.CrudRepository;

public interface RecursoRepositorio extends CrudRepository<Recurso,Long> {
}

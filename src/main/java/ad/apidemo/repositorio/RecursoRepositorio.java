package ad.apidemo.repositorio;

import ad.apidemo.modelo.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepositorio extends JpaRepository<Recurso,Long> {
}

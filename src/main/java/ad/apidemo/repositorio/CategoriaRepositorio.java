package ad.apidemo.repositorio;

import ad.apidemo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPARepository espera dúas cousas, que é(neste caso Repositorio), e o tipo de dato do id (neste caso un Long)
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {
}

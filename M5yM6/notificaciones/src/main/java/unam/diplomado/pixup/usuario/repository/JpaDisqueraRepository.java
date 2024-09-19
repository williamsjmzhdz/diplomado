package unam.diplomado.pixup.usuario.repository;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.usuario.domain.Disquera;

import java.util.Optional;

@Singleton
public class JpaDisqueraRepository implements DisqueraRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disquera> findById(Integer id) {
        Disquera disquera = entityManager.find(Disquera.class, id);
        return disquera != null ? Optional.of(disquera) : Optional.empty();
    }
}

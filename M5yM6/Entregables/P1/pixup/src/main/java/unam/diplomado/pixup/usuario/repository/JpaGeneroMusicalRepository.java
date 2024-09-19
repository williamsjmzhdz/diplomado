package unam.diplomado.pixup.usuario.repository;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.usuario.domain.GeneroMusical;

import java.util.Optional;

@Singleton
public class JpaGeneroMusicalRepository implements GeneroMusicalRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<GeneroMusical> findById(Integer id) {
        GeneroMusical generoMusical = entityManager.find(GeneroMusical.class, id);
        return generoMusical != null ? Optional.of(generoMusical) : Optional.empty();
    }
}

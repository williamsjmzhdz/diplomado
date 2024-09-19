package unam.diplomado.pixup.usuario.repository;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.usuario.domain.Disco;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaDiscoRepository implements DiscoRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        TypedQuery<Disco> typedQuery = entityManager.createQuery(
                "SELECT d FROM Disco d WHERE d.titulo = :titulo AND d.artista.id = :idArtista",
                Disco.class
        );
        typedQuery.setParameter("titulo", titulo);
        typedQuery.setParameter("idArtista", idArtista);
        List<Disco> discos = typedQuery.getResultList();
        return !discos.isEmpty() ? Optional.of(discos.get(0)) : Optional.empty();
    }

    @Override
    public Disco save(Disco disco) {
        System.out.println("DISCO A PERSISTIR: " + disco);
        entityManager.persist(disco);
        System.out.println("DISCO PERSISTIDO EXITOSAMENTE: " + disco);
        return disco;
    }
}

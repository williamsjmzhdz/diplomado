package dgtic.core.repository;

import dgtic.core.model.entities.EspecieEntity;
import dgtic.core.model.entities.LoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EspecieRepository extends JpaRepository<EspecieEntity, Integer> {
    @Query("select c from especie c where c.nombre like %?1%")
    public List<EspecieEntity> findByNombre(String dato);
    @Query(value="SELECT a FROM lote a WHERE a.id_lte NOT IN(SELECT d.lote.id_lte FROM especie d)")
    public List<LoteEntity> especieSinLote();
}

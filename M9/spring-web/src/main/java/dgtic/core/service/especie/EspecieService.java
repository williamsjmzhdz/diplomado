package dgtic.core.service.especie;

import dgtic.core.model.entities.EspecieEntity;
import dgtic.core.model.entities.LoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EspecieService {
    Page<EspecieEntity> buscarEspecie(Pageable pageable);
    List<EspecieEntity> buscarEspecie();
    void guardar(EspecieEntity especieEntity);
    void borrar(Integer id);
    EspecieEntity buscarEspecieId(Integer id);
    List<EspecieEntity> buscarEspeciePatron(String patron);

    List<LoteEntity> especieSinLote();

    List<EspecieEntity> buscarEspecie(Integer id);
}

package dgtic.core.service.especie;

import dgtic.core.model.entities.EspecieEntity;
import dgtic.core.model.entities.LoteEntity;
import dgtic.core.repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EspecieServiceImpl implements EspecieService{

    @Autowired
    private EspecieRepository especieRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<EspecieEntity> buscarEspecie(Pageable pageable) {
        return especieRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public List<EspecieEntity> buscarEspecie() {
        return especieRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(EspecieEntity especieEntity) {
        especieRepository.save(especieEntity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        especieRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public EspecieEntity buscarEspecieId(Integer id) {
        Optional<EspecieEntity> optional = especieRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<EspecieEntity> buscarEspeciePatron(String patron) {
        return especieRepository.findByNombre(patron);
    }

    @Override
    public List<LoteEntity> especieSinLote() {
        return List.of();
    }

    @Override
    public List<EspecieEntity> buscarEspecie(Integer id) {
        return especieRepository.findAllById(Collections.singleton(id));
    }
}

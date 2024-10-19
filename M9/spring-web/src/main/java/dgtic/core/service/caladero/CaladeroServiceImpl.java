package dgtic.core.service.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.repository.CaladeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CaladeroServiceImpl implements CaladeroService{
    @Autowired
    CaladeroRepository caladeroRepository;
    @Override
    @Transactional(readOnly = true)
    public Page<CaladeroEntity> buscarCaladero(Pageable pageable) {
        return caladeroRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CaladeroEntity> buscarCaladero() {
        return caladeroRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(CaladeroEntity caladeroEntity) {
        caladeroRepository.save(caladeroEntity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        caladeroRepository.deleteById(id);
    }

    @Override
    public CaladeroEntity buscarCaladeroId(Integer id) {
        Optional<CaladeroEntity> op=caladeroRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<CaladeroEntity> buscarCaladeroPatron(String patron) {
        return null;
    }
}

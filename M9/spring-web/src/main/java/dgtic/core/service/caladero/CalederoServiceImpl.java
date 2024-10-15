package dgtic.core.service.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.repository.CaladeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalederoServiceImpl implements CaladeroService{

    @Autowired
    private CaladeroRepository caladeroRepository;

    @Override
    public Page<CaladeroEntity> buscarCaladero(Pageable pageable) {
        return caladeroRepository.findAll(pageable);
    }

    @Override
    public void guardar(CaladeroEntity caladeroEntity) {
        caladeroRepository.save(caladeroEntity);
    }

    @Override
    public void borrar(Integer id) {
        caladeroRepository.deleteById(id);
    }

    @Override
    public CaladeroEntity buscarPorId(Integer id) {
        Optional<CaladeroEntity> optional = caladeroRepository.findById(id);
        return optional.orElse(null);
    }
}

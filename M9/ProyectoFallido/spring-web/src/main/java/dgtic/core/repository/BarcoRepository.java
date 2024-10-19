package dgtic.core.repository;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.model.entities.CaladeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcoRepository extends JpaRepository<BarcoEntity, Integer> {
}

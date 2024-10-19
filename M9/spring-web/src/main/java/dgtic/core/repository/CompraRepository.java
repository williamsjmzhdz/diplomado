package dgtic.core.repository;

import dgtic.core.model.entities.CompraEntity;
import dgtic.core.model.entities.CompradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<CompraEntity, Integer> {
}

package dgtic.core.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "barco")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarcoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bco")
    private Integer id_bco;

    @Column(name = "nombre")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres.")
    private String nombre;

    @OneToMany(
            mappedBy = "barco",
            fetch = FetchType.EAGER
    )
    private Set<CapturaEntity> captura;

}

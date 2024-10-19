package dgtic.core.model.entities;

import dgtic.core.validation.NoEspacioNoVacio;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
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

    @NoEspacioNoVacio
    @Length(min=1,max = 50)
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(
            mappedBy = "barco",
            fetch = FetchType.EAGER
    )
    private Set<CapturaEntity> captura;



}

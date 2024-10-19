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

@Entity(name = "caladero")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaladeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clo")
    private Integer id_clo;

    @NoEspacioNoVacio
    @Length(min=1,max = 100)
    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name="extension")
    @Digits(integer = 3,fraction = 2)
    @DecimalMin(value = "0.0",inclusive = false)
    private BigDecimal extension;

    @OneToMany(
            mappedBy = "caladero",
            fetch = FetchType.EAGER
    )
    private Set<CapturaEntity> captura;



}

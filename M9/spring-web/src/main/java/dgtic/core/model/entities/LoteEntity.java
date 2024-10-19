package dgtic.core.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "lote")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_lte;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDateTime fecha;

    @Column(name = "kilos")
    @Min(value = 1,message = "El valor tiene que ser mayor a 0")
    private int kilos;

    @Column(name = "numero_cajas")
    private int numeroCajas;

    @Column(name = "precio_kilo_salida")
    @Digits(integer = 3, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal precioKiloSalida;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "lote",
            fetch = FetchType.EAGER
    )
    private Set<EspecieEntity> especie;
}

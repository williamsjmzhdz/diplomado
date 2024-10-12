package dgtic.core.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @Min(1)
    private int kilos;

    @Column(name = "numero_cajas")
    private int numeroCajas;

    @Column(name = "precio_kilo_salida")
    @Digits(integer = 3, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal precioKiloSalida;

}

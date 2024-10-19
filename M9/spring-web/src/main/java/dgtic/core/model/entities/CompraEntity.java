package dgtic.core.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "compra")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lte")
    private Integer id_lte;

    @Column(name="precio_kilo_final")
    @Digits(integer = 3,fraction = 2)
    @DecimalMin(value = "0.0",inclusive = false)
    private BigDecimal precioKiloFinal;

    @Column(name="precio_total")
    @Digits(integer = 3,fraction = 2)
    @DecimalMin(value = "0.0",inclusive = false)
    private BigDecimal precioTotal;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDateTime fecha;

    @OneToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "id_lte")
    private LoteEntity lote;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigo_cpr")
    private CompradorEntity comprador;

}

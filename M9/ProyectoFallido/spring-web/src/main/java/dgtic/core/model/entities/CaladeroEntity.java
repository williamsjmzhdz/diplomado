package dgtic.core.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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

    @Column(name = "ubicacion")
    @Size(max = 100, message = "La ubicación no puede tener más de 100 caracteres.")
    private String ubicacion;

    @Column(name = "extension")
    @Digits(integer = 3, fraction = 2)
    private BigDecimal extension;

}

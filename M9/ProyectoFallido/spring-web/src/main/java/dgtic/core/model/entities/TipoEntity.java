package dgtic.core.model.entities;

import dgtic.core.validation.NoEspacioNoVacio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tipo")
public class TipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tpo;
    //@NotEmpty
    @NoEspacioNoVacio(message = "No espacio vacio desde mi anotación")
    @Length(min = 1, max = 15)
    @Column(name = "nombre")
    private String nombre;
}

package dgtic.core.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dgtic.core.validation.NoEspacioNoVacio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "tipo",
            fetch = FetchType.EAGER
    )
    private Set<EspecieEntity> especie;
}

package dgtic.core.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity(name = "especie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspecieEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_epe;
    @NotEmpty
    @Length(min = 1,max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private String imagen;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_tpo")
    private TipoEntity tipo;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_lte")
    private LoteEntity lote;

    @OneToMany(
            mappedBy = "especie",
            fetch = FetchType.EAGER
    )
    private Set<CapturaEntity> captura;

}

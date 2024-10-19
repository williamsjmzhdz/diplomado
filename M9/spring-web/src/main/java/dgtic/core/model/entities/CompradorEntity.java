package dgtic.core.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Entity(name = "comprador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_cpr;

    @Column(name = "nombre")
    @NotEmpty(message = "No puede estar este campo vacio")
    private String nombre;

    @Column(name = "apellido_paterno")
    @NotEmpty(message = "No puede estar este campo vacio")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "direccion")
    private String direccion;
    @Column(name = "correo")
    private String correo;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "comprador",
            fetch = FetchType.EAGER
    )
    private Set<CompraEntity> compra;

}

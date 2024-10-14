package dgtic.core.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "comprador")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cpr")
    private Integer codigo_cpr;

    @NotBlank(message = "El nombre es obligatorio y no puede estar en blanco.")
    @Size(max = 15, message = "El nombre no puede tener más de 15 caracteres.")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El apellido paterno es obligatorio y no puede estar en blanco.")
    @Size(max = 15, message = "El apellido paterno no puede tener más de 15 caracteres.")
    @Column(name = "apellido_paterno")
    private String apellido_paterno;

    @NotBlank(message = "El apellido materno es obligatorio y no puede estar en blanco.")
    @Size(max = 15, message = "El apellido materno no puede tener más de 15 caracteres.")
    @Column(name = "apellido_materno")
    private String apellido_materno;

    @NotBlank(message = "La dirección es obligatoria y no puede estar en blanco.")
    @Size(max = 200, message = "La dirección no puede tener más de 200 caracteres.")
    @Column(name = "direccion")
    private String direccion;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "Debe proporcionar un correo electrónico válido.")
    @Size(max = 80, message = "El correo no puede tener más de 80 caracteres.")
    @Column(name = "correo")
    private String correo;
}

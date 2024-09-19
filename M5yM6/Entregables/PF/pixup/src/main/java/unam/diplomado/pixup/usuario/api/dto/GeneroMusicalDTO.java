package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneroMusicalDTO {

    @NotNull(message = "ID es requerido.")
    private Integer id;

}

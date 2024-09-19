package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.usuario.domain.GeneroMusical;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDiscoDTO {

    @NotNull(message = "Disco es requerido para realizar su registro.")
    @Valid
    private DiscoRequestDTO disco;

    @NotNull(message = "Artista es requerido para realizar el registro de un disco.")
    @Valid
    private ArtistaDTO artista;

    @NotNull(message = "Disquera es requerida para realizar el registro de un disco.")
    @Valid
    private DisqueraDTO disquera;

    @NotNull(message = "Género musical es requerido para realizar el registro de un disco.")
    @Valid
    private GeneroMusicalDTO generoMusical;

}

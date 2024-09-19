package unam.diplomado.pixup.usuario.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class DiscoResponseDTO {

    private String artista;
    private String titulo;
    private ZonedDateTime fechaLanzamiento;

}

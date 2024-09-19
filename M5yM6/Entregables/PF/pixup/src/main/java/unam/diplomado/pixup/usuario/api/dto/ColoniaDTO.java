package unam.diplomado.pixup.usuario.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColoniaDTO {

    private Integer id;
    private String nombre;
    private String cp;
    private String municipio;
    private String estado;

}

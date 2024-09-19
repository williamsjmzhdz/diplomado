package unam.diplomado.pixup.usuario.api.dto;

import jakarta.ejb.Singleton;
import unam.diplomado.pixup.usuario.domain.Colonia;

@Singleton
public class ColoniaMapper {

    public ColoniaDTO toDto(Colonia colonia) {
        return new ColoniaDTO(
                colonia.getId(),
                colonia.getNombre(),
                colonia.getCp(),
                colonia.getMunicipio().getNombre(),
                colonia.getMunicipio().getEstado().getNombre()
        );
    }

}

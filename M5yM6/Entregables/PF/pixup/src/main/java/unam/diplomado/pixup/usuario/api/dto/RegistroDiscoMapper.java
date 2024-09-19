package unam.diplomado.pixup.usuario.api.dto;

import unam.diplomado.pixup.usuario.domain.Artista;
import unam.diplomado.pixup.usuario.domain.Disco;
import unam.diplomado.pixup.usuario.domain.Disquera;
import unam.diplomado.pixup.usuario.domain.GeneroMusical;

public class RegistroDiscoMapper {

    public DiscoResponseDTO toDto(Disco disco) {
        return new DiscoResponseDTO(
                disco.getArtista().getNombre(),
                disco.getTitulo(),
                disco.getFechaLanzamiento()
        );
    }

    public Disco toDisco(DiscoRequestDTO discoRequestDTO) {
        return new Disco(
                discoRequestDTO.getTitulo(),
                discoRequestDTO.getPrecio(),
                discoRequestDTO.getExistencia(),
                discoRequestDTO.getDescuento(),
                discoRequestDTO.getFechaLanzamiento(),
                discoRequestDTO.getImagen()
        );
    }

    public Artista toArtista(ArtistaDTO artistaDTO) {
        return new Artista(
                artistaDTO.getId()
        );
    }

    public Disquera toDisquera(DisqueraDTO disqueraDTO) {
        return new Disquera(
                disqueraDTO.getId()
        );
    }

    public GeneroMusical toGeneroMusical(GeneroMusicalDTO generoMusicalDTO) {
        return new GeneroMusical(
                generoMusicalDTO.getId()
        );
    }
}

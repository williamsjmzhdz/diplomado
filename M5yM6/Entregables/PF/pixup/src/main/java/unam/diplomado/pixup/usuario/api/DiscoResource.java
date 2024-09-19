package unam.diplomado.pixup.usuario.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import unam.diplomado.pixup.usuario.api.dto.DiscoResponseDTO;
import unam.diplomado.pixup.usuario.api.dto.RegistroDiscoDTO;
import unam.diplomado.pixup.usuario.api.dto.RegistroDiscoMapper;
import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.service.DiscoService;

public class DiscoResource implements DiscoApi {
    @Inject
    private DiscoService discoService;
    @Inject
    private RegistroDiscoMapper registroDiscoMapper;


    @Override
        public Response altaDisco(RegistroDiscoDTO registroDiscoDTO) {

        // Mapeos de DTOs a modelos de dominio
        Disco disco = registroDiscoMapper.toDisco(registroDiscoDTO.getDisco());
        System.out.println("Disco preparado: " + disco);
        Artista artista = registroDiscoMapper.toArtista(registroDiscoDTO.getArtista());
        Disquera disquera = registroDiscoMapper.toDisquera(registroDiscoDTO.getDisquera());
        GeneroMusical generoMusical = registroDiscoMapper.toGeneroMusical(registroDiscoDTO.getGeneroMusical());

        // Prepara disco
        disco.setArtista(artista);
        disco.setDisquera(disquera);
        disco.setGeneroMusical(generoMusical);

        // Registra el disco
        Disco discoPersistido = discoService.registrarDisco(disco);
        DiscoResponseDTO discoResponseDTO = registroDiscoMapper.toDto(discoPersistido);

        return Response.status(Response.Status.CREATED).entity(discoResponseDTO).build();

    }
}

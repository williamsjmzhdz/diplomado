package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.repository.ArtistaRepository;
import unam.diplomado.pixup.usuario.repository.DiscoRepository;
import unam.diplomado.pixup.usuario.repository.DisqueraRepository;
import unam.diplomado.pixup.usuario.repository.GeneroMusicalRepository;

import java.util.Optional;

@Stateless
public class DiscoServiceImpl implements DiscoService {

    @Inject
    private DisqueraRepository disqueraRepository;
    @Inject
    private ArtistaRepository artistaRepository;
    @Inject
    private GeneroMusicalRepository generoMusicalRepository;
    @Inject
    private DiscoRepository discoRepository;

    @Override
    public Disco registrarDisco(Disco disco) {
        Integer disqueraId = disco.getDisquera().getId();
        Integer artistaId = disco.getArtista().getId();
        Integer generoMusicalId = disco.getGeneroMusical().getId();


        // Valida que exista la disquera
        Optional<Disquera> disquera = disqueraRepository.findById(disqueraId);
        if (disquera.isEmpty()) {
            throw new DisqueraNotFoundException(disqueraId);
        }
        disco.setDisquera(disquera.get());

        // Valida que exista el artista
        Optional<Artista> artista = artistaRepository.findById(artistaId);
        if (artista.isEmpty()) {
            throw new ArtistaNotFoundException(artistaId);
        }
        disco.setArtista(artista.get());

        // Valida que exista el género musical
        Optional<GeneroMusical> generoMusical = generoMusicalRepository.findById(generoMusicalId);
        if (generoMusical.isEmpty()) {
            throw new GeneroMusicalNotFoundException(generoMusicalId);
        }
        disco.setGeneroMusical(generoMusical.get());

        // Valida que no exista el disco
        Optional<Disco> discoExistente = discoRepository.findByTituloAndArtista(disco.getTitulo(), artistaId);
        if (!discoExistente.isEmpty()) {
            throw new DiscoAlreadyExistsException(disco.getTitulo(), artistaId);
        }

        // Guarda el disco
        return discoRepository.save(disco);

    }
}

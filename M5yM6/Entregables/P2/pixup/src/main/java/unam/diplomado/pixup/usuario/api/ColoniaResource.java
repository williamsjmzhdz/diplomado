package unam.diplomado.pixup.usuario.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.usuario.api.dto.ColoniaDTO;
import unam.diplomado.pixup.usuario.api.dto.ColoniaMapper;
import unam.diplomado.pixup.usuario.domain.Colonia;
import unam.diplomado.pixup.usuario.repository.ColoniaRepository;
import unam.diplomado.pixup.usuario.service.ColoniaService;

import java.util.Collection;


public class ColoniaResource implements ColoniaApi {
    @Inject
    private ColoniaRepository coloniaRepository;

    @Inject
    private ColoniaService coloniaService;

    @Inject
    private ColoniaMapper coloniaMapper;

    @Override
    public Colonia getColoniaById(Integer id) {
        return coloniaService.obtenerColoniaPorId(id);
    }

    @Override
    public Collection<ColoniaDTO> getColoniasByCp(String cp) {

        return coloniaRepository.ListfindByCp(cp)
                .stream()
                .map(colonia -> coloniaMapper.toDto(colonia))
                .toList();

    }

    @Override
    public Response createColonia(Colonia colonia) {
        Colonia coloniaCreada = coloniaService.crearColonia(colonia);
        return Response.status(Response.Status.CREATED).entity(coloniaCreada).build();
    }

    @Override
    public void deleteColonia(Integer id) {
        coloniaService.eliminarColoniaPorId(id);
    }
}

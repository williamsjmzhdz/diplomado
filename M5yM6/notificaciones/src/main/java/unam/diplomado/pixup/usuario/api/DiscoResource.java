package unam.diplomado.pixup.usuario.api;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ejb.EJBException;

import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.service.DiscoService;

public class DiscoResource implements DiscoApi {
    @Inject
    private DiscoService discoService;


    @Override
    public Response altaDisco(Disco disco) {

        Response response = null;

        try {
            Disco discoPersistido = discoService.registrarDisco(disco);
            response = Response.status(Response.Status.CREATED).entity(discoPersistido).build();
        } catch (EJBException ejbEx) {
            Throwable cause = ejbEx.getCause();
            if (cause instanceof DiscoAlreadyExistsException) {
                response = Response.status(Response.Status.CONFLICT).entity(cause.getMessage()).build();
            } else if (cause instanceof ArtistaNotFoundException ||
                    cause instanceof DisqueraNotFoundException ||
                    cause instanceof GeneroMusicalNotFoundException) {
                response = Response.status(Response.Status.PRECONDITION_REQUIRED).entity(cause.getMessage()).build();
            } else if (cause instanceof ConstraintViolationException) {
                response = Response.status(Response.Status.BAD_REQUEST).entity(cause.getMessage()).build();
            }
        }

        return response;
    }
}

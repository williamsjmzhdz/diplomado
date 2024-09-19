package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.usuario.domain.ArtistaNotFoundException;
import unam.diplomado.pixup.usuario.domain.DiscoAlreadyExistsException;

@Provider
public class ArtistaNotFoundExceptionMapper implements ExceptionMapper<ArtistaNotFoundException> {
    @Override
    public Response toResponse(ArtistaNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(e.getMessage())
                .build();
    }
}

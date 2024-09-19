package unam.diplomado.pixup.usuario.api.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.usuario.domain.ArtistaNotFoundException;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage())
                .build();
    }
}

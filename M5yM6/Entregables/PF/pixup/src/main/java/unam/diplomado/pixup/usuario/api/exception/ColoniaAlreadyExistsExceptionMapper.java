package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.usuario.domain.ColoniaAlreadyExistsException;
import unam.diplomado.pixup.usuario.domain.ColoniaNotFoundException;

@Provider
public class ColoniaAlreadyExistsExceptionMapper implements ExceptionMapper<ColoniaAlreadyExistsException> {
    @Override
    public Response toResponse(ColoniaAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}

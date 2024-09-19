package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.usuario.domain.ColoniaNotFoundException;

@Provider
public class ColoniaNotFoundExceptionMapper implements ExceptionMapper<ColoniaNotFoundException> {
    @Override
    public Response toResponse(ColoniaNotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();
    }
}

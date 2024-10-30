package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.EstadoDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IEstadoDtoService {

    // Obtener lista de todos los estados
    List<EstadoDto> getEstadosList();

    // Obtener un estado por su ID
    Optional<EstadoDto> getEstadoById(int idEstado);

    // Crear un nuevo estado
    EstadoDto createEstado(EstadoDto estadoDto);

    // Actualizar un estado existente
    EstadoDto updateEstado(EstadoDto estadoDto);

    // Eliminar un estado por su ID
    boolean deleteEstado(int idEstado);

    // Obtener estados con alumnos en un estado específico
    List<EstadoDto> findEstadosByNombreAlumno(String nombre);

    // Paginación de estados
    List<EstadoDto> getEstadosPageable(int page, int size, String dirSort, String sort);
}

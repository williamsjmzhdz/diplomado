package mx.unam.dgtic.controller;

import mx.unam.dgtic.dto.EstadoDto;
import mx.unam.dgtic.service.IEstadoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v2/estados")
public class EstadoDtoController {

    @Autowired
    private IEstadoDtoService estadoDtoService;

    // Obtener todos los estados
    @GetMapping(path = "/")
    public List<EstadoDto> getAllEstados() {
        return estadoDtoService.getEstadosList();
    }

    // Obtener estado por ID
    @GetMapping(path = "/{idEstado}")
    public ResponseEntity<EstadoDto> getByIdEstado(@PathVariable int idEstado) {
        Optional<EstadoDto> estadoDto = estadoDtoService.getEstadoById(idEstado);
        if (estadoDto.isPresent()) {
            return ResponseEntity.ok(estadoDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo estado
    @PostMapping(path = "/")
    public ResponseEntity<EstadoDto> createEstadoDto(@RequestBody EstadoDto estadoDto) throws URISyntaxException {
        EstadoDto nuevoEstado = estadoDtoService.createEstado(estadoDto);
        URI location = new URI("/api/v2/estados/" + nuevoEstado.getIdEstado());
        return ResponseEntity.created(location).body(nuevoEstado);
    }

    // Modificar estado (PUT)
    @PutMapping(path = "/{idEstado}")
    public ResponseEntity<EstadoDto> modificarEstado(
            @PathVariable int idEstado,
            @RequestBody EstadoDto estadoDto
    ) {
        estadoDto.setIdEstado(idEstado);
        EstadoDto estadoModificado = estadoDtoService.updateEstado(estadoDto);
        return ResponseEntity.ok(estadoModificado);
    }

    // Actualización parcial de estado (PATCH)
    @PatchMapping(path = "/{idEstado}")
    public ResponseEntity<EstadoDto> actualizacionParcial(
            @PathVariable int idEstado,
            @RequestBody EstadoDto estadoDto
    ) {
        Optional<EstadoDto> estadoDb = estadoDtoService.getEstadoById(idEstado);
        if (estadoDb.isPresent()) {
            EstadoDto modificable = estadoDb.get();
            if (estadoDto.getEstado() != null) modificable.setEstado(estadoDto.getEstado());
            if (estadoDto.getAbreviatura() != null) modificable.setAbreviatura(estadoDto.getAbreviatura());
            return ResponseEntity.ok(estadoDtoService.updateEstado(modificable));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar estado
    @DeleteMapping(path = "/{idEstado}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable int idEstado) {
        boolean eliminado = estadoDtoService.deleteEstado(idEstado);
        if (eliminado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para buscar estados por nombre de alumno
    @GetMapping(path = "/alumnos/{nombre}")
    public ResponseEntity<List<EstadoDto>> getEstadosByNombreAlumno(@PathVariable String nombre) {
        List<EstadoDto> estados = estadoDtoService.findEstadosByNombreAlumno(nombre);
        return ResponseEntity.ok(estados);
    }

    @GetMapping(path = "/paginado")
    public ResponseEntity<List<EstadoDto>> getPaginadoEstado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "ASC") String dir,
            @RequestParam(defaultValue = "idEstado") String sort
    ) {
        List<EstadoDto> estados = estadoDtoService.getEstadosPageable(page, size, dir, sort);
        return ResponseEntity.ok(estados);
    }


}

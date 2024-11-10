package mx.unam.dgtic.controller;

import jakarta.validation.Valid;
import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.exception.EstadoNoExisteException;
import mx.unam.dgtic.model.Alumno;
import mx.unam.dgtic.service.AlumnoDtoService;
import mx.unam.dgtic.service.IAlumnoDtoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v2/alumnos")
public class AlumnoDtoController {

    @Autowired
    IAlumnoDtoService alumnoDtoService;

    @GetMapping(path = "/")
    public List<AlumnoDto> getAllDto() {
        return alumnoDtoService.getAlumnosList();
    }

    // Obtener matrícula
    @GetMapping(path = "/{matricula}")
    public ResponseEntity<AlumnoDto> getByIdDto(@PathVariable String matricula) {
        Optional<AlumnoDto> alumnoDto = alumnoDtoService.getAlumnoById(matricula);
        if (alumnoDto.isPresent()) {
            return ResponseEntity.ok(alumnoDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<AlumnoDto> createAlumnoDto(@RequestBody @Valid AlumnoDto alumnoDto) throws ParseException, URISyntaxException, EstadoNoExisteException {
        AlumnoDto alumnoDto1 = alumnoDtoService.createAlumno(alumnoDto);
        URI location = new URI("api/v2/alumnos/" + alumnoDto1.getMatricula());
        return ResponseEntity.created(location).body(alumnoDto1);
    }

    @PutMapping(path = "/{matricula}")
    public ResponseEntity<AlumnoDto> modificarAlumno(
            @PathVariable String matricula,
            @RequestBody AlumnoDto alumnoDto
    ) throws ParseException, EstadoNoExisteException {
        alumnoDto.setMatricula(matricula);
        AlumnoDto alumnoModificado = alumnoDtoService.updateAlumno(alumnoDto);
        return ResponseEntity.ok(alumnoModificado);
    }

    @PatchMapping(path = "/{matricula}")
    public ResponseEntity<AlumnoDto> actualizacionParcialDto(
            @PathVariable String matricula,
            @RequestBody AlumnoDto alumnoDto
    ) throws ParseException, EstadoNoExisteException {
        Optional<AlumnoDto> alumnoDb = alumnoDtoService.getAlumnoById(matricula);
        if (alumnoDb.isPresent()) {
            AlumnoDto modificable = alumnoDb.get();
            if (alumnoDto.getNombre() != null) modificable.setNombre(alumnoDto.getNombre());
            if (alumnoDto.getPaterno() != null) modificable.setPaterno(alumnoDto.getPaterno());
            if (alumnoDto.getFnac() != null) modificable.setFnac(alumnoDto.getFnac());
            if (alumnoDto.getEstatura() != 0.0) modificable.setEstatura(alumnoDto.getEstatura());
            if (alumnoDto.getEstado() != null) modificable.setEstado(alumnoDto.getEstado());
            return ResponseEntity.ok(alumnoDtoService.updateAlumno(modificable));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{matricula}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable String matricula) {
        boolean eliminado = alumnoDtoService.deleteAlumno(matricula);
        if (eliminado) {
            return ResponseEntity.ok().build(); // 200 Success si la eliminación fue exitosa
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si no se encontró el alumno
        }
    }

    @GetMapping(path = "/estados/{edo}")
    public ResponseEntity<List<AlumnoDto>> getByEstado(
            @PathVariable String edo
    ) {
        return ResponseEntity.ok(alumnoDtoService.findAlumnosByEstado(edo));
    }

    // /api/v2/alumnos/paginado?page=0&size=2&dir=asc&sort=nombre
    @GetMapping(path = "/paginado")
    public ResponseEntity<List<Alumno>> getPaginadoAlumno(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "asc") String dir,
            @RequestParam(defaultValue = "matricula") String sort
    ) {
        return ResponseEntity.ok(alumnoDtoService.getAlumnosPageable(
                page,
                size,
                dir,
                sort
        ));
    }

    @GetMapping(path = "/ping/{veces}")
    public ResponseEntity<String> ping(@PathVariable int veces) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            str.append("\n TTL " + i);
        }
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(str.toString());
    }
}

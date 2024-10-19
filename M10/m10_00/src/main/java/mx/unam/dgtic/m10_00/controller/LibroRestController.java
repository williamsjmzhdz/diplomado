package mx.unam.dgtic.m10_00.controller;

import mx.unam.dgtic.m10_00.model.Libro;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.HashMap;

@RestController
@RequestMapping("/api/libreria")
public class LibroRestController {

    public static final String NOMBRE = "Francisco Williams Jiménez Hernández";
    HashMap<Integer, Libro> libreria;

    public LibroRestController() {
        libreria = new HashMap<>();
        libreria.put(0, new Libro(0, "Módulo 10", "Williams Jiménez"));
        libreria.put(1, new Libro(1, "El perfume", "Patrick Suskind"));
        libreria.put(2, new Libro(2, "El señor de los anillos", "J.R. Tolkien"));
        libreria.put(3, new Libro(3, "Fundación", "Isaac Asimov"));
    }

    @GetMapping("/saludar")
    public String saludar() {
        return "Hola " + NOMBRE;
    }

    @GetMapping(
            path = "/",
            headers = {"Accept=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HashMap<Integer, Libro>>   getAll() {
        return new ResponseEntity<>(libreria, HttpStatus.OK);
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Libro> getLibro(@PathVariable Integer id) {
        Libro libro = libreria.get(id);
        if (libro != null) {
            return ResponseEntity.ok(libro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
        int id = 1;
        while (libreria.containsKey(id)) {
            id++;
        }
        libro.setId(id);
        libreria.put(id, libro);
        return new ResponseEntity<>(libro, HttpStatus.CREATED);
    }

    @PutMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Libro> reemplazarLibro(@PathVariable int id, @RequestBody Libro libro) {

        if (libreria.containsKey(id)) {
            libreria.replace(id, libro);
            return ResponseEntity.ok(libreria.get(id));
        } else {
            libreria.put(id, libro);
            return new ResponseEntity<>(libreria.get(id), HttpStatus.CREATED);
        }

    }

    @PutMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String errorPut() {
        return "{'mensaje': 'Este método (PUT) no soporta peticiones sin id.'";
    }

    @PatchMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Libro> actualizaLibro(@PathVariable int id, @RequestBody Libro libro) {
        Libro dbLibro = libreria.get(id);

        if (libro == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        if (dbLibro == null) {
            return ResponseEntity.notFound().build();
        }

        if (libro.getAutor() != null) {
            dbLibro.setAutor(libro.getAutor());
        }

        if (libro.getTitulo() != null) {
            dbLibro.setTitulo(libro.getTitulo());
        }

        libreria.replace(id, dbLibro);

        return ResponseEntity.ok(libreria.get(id));
    }

    @PatchMapping("/")
    public ResponseEntity<String> patchNoPermitido() {
        return new ResponseEntity<>("{'msg': 'Acción no permitida.'}", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @DeleteMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Libro> deleteLibro(@PathVariable int id) {
        if (libreria.containsKey(id)) {
            return ResponseEntity.ok(libreria.remove(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

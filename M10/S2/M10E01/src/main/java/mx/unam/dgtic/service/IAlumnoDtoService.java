package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.exception.EstadoNoExisteException;
import mx.unam.dgtic.model.Alumno;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IAlumnoDtoService {

    public List<AlumnoDto> getAlumnosList();

    public Optional<AlumnoDto> getAlumnoById(String matricula);

    public List<Alumno> getAlumnosPageable(int pagina, int size, String dirSort, String sort);

    public AlumnoDto updateAlumno(AlumnoDto alumno) throws ParseException, EstadoNoExisteException;

    public AlumnoDto createAlumno(AlumnoDto alumno) throws ParseException, EstadoNoExisteException;

    public boolean deleteAlumno(String matricula);

    public List<AlumnoDto> findAlumnosByEstado(String estado);

}

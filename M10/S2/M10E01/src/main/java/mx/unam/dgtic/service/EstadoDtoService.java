package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.EstadoDto;
import mx.unam.dgtic.model.Estado;
import mx.unam.dgtic.repository.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoDtoService implements IEstadoDtoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EstadoDto> getEstadosList() {
        List<Estado> estados = (List<Estado>) estadoRepository.findAll();
        return estados.stream().map(this::convertToDto).toList();
    }

    @Override
    public Optional<EstadoDto> getEstadoById(int idEstado) {
        Optional<Estado> estado = estadoRepository.findById(idEstado);
        return estado.map(this::convertToDto);
    }

    @Override
    public EstadoDto createEstado(EstadoDto estadoDto) {
        Estado estado = estadoRepository.save(this.convertToEntity(estadoDto));
        return this.convertToDto(estado);
    }

    @Override
    public EstadoDto updateEstado(EstadoDto estadoDto) {
        Estado estadoActualizado = estadoRepository.save(this.convertToEntity(estadoDto));
        return this.convertToDto(estadoActualizado);
    }

    @Override
    public boolean deleteEstado(int idEstado) {
        Optional<Estado> estado = estadoRepository.findById(idEstado);
        if (estado.isPresent()) {
            estadoRepository.delete(estado.get());
            return true;
        }
        return false;
    }

    // Implementación de la búsqueda de estados por nombre de alumno
    @Override
    public List<EstadoDto> findEstadosByNombreAlumno(String nombre) {
        List<Estado> estados = estadoRepository.findEstadosByAlumnoNombreLike(nombre);
        return estados.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<EstadoDto> getEstadosPageable(int page, int size, String dirSort, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(dirSort.toUpperCase()), sort);
        Page<Estado> pageResult = estadoRepository.findAll(pageRequest);
        return pageResult.map(this::convertToDto).stream().toList(); // Convierte el Page en una lista
    }


    private EstadoDto convertToDto(Estado estado) {
        return modelMapper.map(estado, EstadoDto.class);
    }

    private Estado convertToEntity(EstadoDto estadoDto) {
        return modelMapper.map(estadoDto, Estado.class);
    }
}


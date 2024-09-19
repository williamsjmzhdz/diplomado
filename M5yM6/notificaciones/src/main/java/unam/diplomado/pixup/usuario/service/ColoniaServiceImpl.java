package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.repository.ColoniaRepository;
import unam.diplomado.pixup.usuario.repository.MunicipioRepository;

import java.util.Optional;

// Nota: los métodos de la capa de negocio deben lanzar una excepción siempre que
// una regla de negocio no se cumpla; nunca retornar null. La excepción lanzada está obligada
// a extender de RuntimeExcepcion, no de Exception.

@Stateless
public class ColoniaServiceImpl implements ColoniaService {

    @Inject
    private ColoniaRepository coloniaRepository;

    @Inject
    private MunicipioRepository municipioRepository;

    @Override
    public Colonia obtenerColoniaPorId(Integer id) {
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()) {
            return colonia.get();
        }
        throw new ColoniaNotFoundException(id);
    }

    @Override
    public Colonia crearColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente =
                coloniaRepository.findByCpAndNombre(colonia.getCp(), colonia.getNombre());
        if (coloniaExistente.isEmpty()) {
            Optional<Municipio> municipioExistente =
                    municipioRepository.findById(colonia.getMunicipio().getId());
            if (municipioExistente.isEmpty()) {
                throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
            }
            colonia.setMunicipio(municipioExistente.get());
            return coloniaRepository.saveOrUpdate(colonia);
        }
        throw new ColoniaAlreadyExistsException(colonia.getCp(), colonia.getNombre());
    }

    @Override
    public void eliminarColoniaPorId(Integer id) {
        /**
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()) {
            coloniaRepository.delete(colonia.get());
        }
         */
        coloniaRepository.findById(id).ifPresent(colonia -> coloniaRepository.delete(colonia));
    }
}

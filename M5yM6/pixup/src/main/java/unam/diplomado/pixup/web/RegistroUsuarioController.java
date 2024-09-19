package unam.diplomado.pixup.web;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.java.Log;
import unam.diplomado.pixup.usuario.api.dto.ColoniaDTO;
import unam.diplomado.pixup.usuario.api.dto.ColoniaMapper;
import unam.diplomado.pixup.usuario.domain.Colonia;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.repository.ColoniaRepository;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.pixup.usuario.service.ColoniaService;
import unam.diplomado.pixup.usuario.service.UsuarioService;

import java.io.Serializable;
import java.util.Collection;

@Named("registro")
@ViewScoped
@Log
public class RegistroUsuarioController implements Serializable {

    // Model
    private Usuario usuario;
    private Domicilio domicilio;
    private Collection<ColoniaDTO> colonias;
    private Collection<TipoDomicilio> tiposDomicilio;
    private String cp;
    private String coloniaId;
    private String tipoDomicilioId;

    @Inject
    transient private TipoDomicilioRepository tipoDomicilioRepository;
    @Inject
    transient private ColoniaService coloniaService;
    @Inject
    transient private ColoniaRepository coloniaRepository;
    @Inject
    transient private UsuarioService usuarioService;
    @Inject
    transient private ColoniaMapper coloniaMapper;

    @PostConstruct
    public void init( ) {
        usuario = new Usuario();
        domicilio = new Domicilio();
        tiposDomicilio = tipoDomicilioRepository.findAll();
    }

    public void findColoniaByCp() {
        log.info("colonia seleccionada: " + cp);
        colonias = coloniaRepository.ListfindByCp(cp)
                .stream()
                .map(colonia -> coloniaMapper.toDto(colonia))
                .toList();
    }

    public String altaUsuario() {

        log.info("Datos Usuario: " + usuario);
        domicilio.setColonia(new Colonia());
        domicilio.setTipoDomicilio(new TipoDomicilio());
        domicilio.getColonia().setId(Integer.valueOf(coloniaId));
        domicilio.getTipoDomicilio().setId(Integer.valueOf(tipoDomicilioId));

        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario, domicilio);
        log.info("Usuario Creado: " + usuarioCreado);
        return "/registro_resultado?faces-redirect=true";

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Collection<ColoniaDTO> getColonias() {
        return colonias;
    }

    public void setColonias(Collection<ColoniaDTO> colonias) {
        this.colonias = colonias;
    }

    public Collection<TipoDomicilio> getTiposDomicilio() {
        return tiposDomicilio;
    }

    public void setTiposDomicilio(Collection<TipoDomicilio> tiposDomicilio) {
        this.tiposDomicilio = tiposDomicilio;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getColoniaId() {
        return coloniaId;
    }

    public void setColoniaId(String coloniaId) {
        this.coloniaId = coloniaId;
    }

    public String getTipoDomicilioId() {
        return tipoDomicilioId;
    }

    public void setTipoDomicilioId(String tipoDomicilioId) {
        this.tipoDomicilioId = tipoDomicilioId;
    }

}

package unam.diplomado.notificaciones.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.usuario.domain.Usuario;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Notificacion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="fecha_notificacion")
    private Date fechaNotificacion;
    @ManyToOne(targetEntity=Usuario.class)
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;
    @ManyToOne(targetEntity=TipoNotificacion.class)
    @JoinColumn(name="id_tipo_notificacion", nullable=false)
    private TipoNotificacion tipoNotificacion;

}

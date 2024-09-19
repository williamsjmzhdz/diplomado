package unam.diplomado.notificaciones.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="tipo_notificacion")
public class TipoNotificacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    @Column(name="ruta_plantilla")
    private String rutaPlantilla;

}
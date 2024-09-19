package unam.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor // Las entidades deben tener un método constructor sin argumentos para que Jakarta puedan instanciarla automáticamente durante la recuperación de datos desde la base de datos.
@Entity
@Table(name = "tipo_domicilio")
public class TipoDomicilio implements Serializable { // Las entidades que deben ser transmitidas por la red o almacenadas en disco deben ser serializables para que se puedan convertir en una secuencia de bytes.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;

}

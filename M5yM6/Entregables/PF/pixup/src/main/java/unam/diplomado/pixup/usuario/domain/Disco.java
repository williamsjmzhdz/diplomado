package unam.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Disco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "El título es requerido")
    private String titulo;
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede menor a cero.")
    private Float precio;
    @Min(value = 0, message = "La existencia no puede ser menor a cero.")
    private Integer existencia;
    @DecimalMin(value = "0.0", inclusive = true, message = "El descuento no puede menor a cero.")
    private Float descuento;
    @Column(name = "fecha_lanzamiento")
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private ZonedDateTime fechaLanzamiento;
    private String imagen;
    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name = "id_disquera", nullable = false)
    @NotNull(message = "La disquera no puede ser nulo.")
    private Disquera disquera;
    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name = "id_artista", nullable = false)
    @NotNull(message = "El/la artista no puede ser nulo.")
    private Artista artista;
    @ManyToOne(targetEntity = GeneroMusical.class)
    @JoinColumn(name = "id_genero_musical", nullable = false)
    @NotNull(message = "El genero musical no puede ser nulo.")
    private GeneroMusical generoMusical;

    public Disco(String titulo, Float precio, Integer existencia,
                 Float descuento, ZonedDateTime fechaLanzamiento, String imagen) {
        this.titulo = titulo;
        this.precio = precio;
        this.existencia = existencia;
        this.descuento = descuento;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagen = imagen;
    }

}

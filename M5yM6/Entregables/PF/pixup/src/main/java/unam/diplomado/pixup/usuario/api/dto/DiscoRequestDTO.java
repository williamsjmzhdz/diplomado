package unam.diplomado.pixup.usuario.api.dto;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscoRequestDTO {

    @NotNull(message = "El título es requerido")
    @NotBlank(message = "El título es requerido")
    private String titulo;
    @NotNull(message = "El precio no puede ser nulo.")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede menor a cero.")
    private Float precio;
    @NotNull
    @Min(value = 0, message = "La existencia no puede ser menor a 0.")
    private Integer existencia;
    @DecimalMin(value = "0.0", inclusive = true, message = "El descuento no puede menor a cero.")
    @DecimalMax(value = "100.0", inclusive = true, message = "El descuento no puede ser mayor a cien.")
    @NotNull
    private Float descuento;
    @NotNull
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private ZonedDateTime fechaLanzamiento;
    @NotNull
    @NotBlank(message = "Imagen es requerida.")
    private String imagen;

}

package dgtic.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPago {

    private Integer id;
    private String nombreTitular;
    private String numeroTarjeta;
    private LocalDateTime fechaExpiracion;
    private String codigoSeguridad;
    private TipoTarjeta tipoTarjeta;
    private BigDecimal monto;
    private Usuario usuario;
}


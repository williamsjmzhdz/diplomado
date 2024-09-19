package dgtic.core.modelo;

import dgtic.core.excepcion.CreditosInvalidosException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {

    private Long id;
    private String nombre;
    private Integer creditos;

    public Materia(String nombre, Integer creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void setCreditos(Integer creditos) {

        if (creditos < 0)
            throw new CreditosInvalidosException("Créditos inválidos.");

        this.creditos = creditos;

    }

}

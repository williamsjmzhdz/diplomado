package dgtic.core.validation;


import dgtic.core.model.entities.TipoEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TipoValidacion implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TipoEntity tipo = (TipoEntity) target;
        if (tipo.getNombre() == null
                || tipo.getNombre().regionMatches(0, " ", 0, 1)
                || tipo.getNombre().isEmpty()) {
            errors.rejectValue("nombre", "NotEmpty.tipo.nombre");
        }
    }
}

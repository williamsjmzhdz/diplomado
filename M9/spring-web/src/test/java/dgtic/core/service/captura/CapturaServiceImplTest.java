package dgtic.core.service.captura;

import dgtic.core.model.entities.*;
import dgtic.core.service.barco.BarcoService;
import dgtic.core.service.caladero.CaladeroService;
import dgtic.core.service.especie.EspecieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
class CapturaServiceImplTest {

    @Autowired
    private CapturaService capturaService;

    @Autowired
    private EspecieService especieService;

    @Autowired
    private CaladeroService caladeroService;

    @Autowired
    private BarcoService barcoService;

    @Test
    void grabar() {
        List<EspecieEntity> listaEspecie = especieService.buscarEspecie();
        System.out.println(listaEspecie);
        List<BarcoEntity> listaBarco = barcoService.buscarBarco();
        System.out.println(listaBarco);
        List<CaladeroEntity> listaCaladero = caladeroService.buscarCaladero();
        System.out.println(listaCaladero);

        EspecieEntity especie = especieService.buscarEspecieId(1);
        BarcoEntity barco = barcoService.buscarPorId(2);
        CaladeroEntity caladero = caladeroService.buscarPorId(3);
        LocalDateTime tiempo= LocalDateTime.of(LocalDate.now(), LocalTime.now());

        CapturaEntity captura = CapturaEntity.builder()
                .peso(BigDecimal.valueOf(34.45))
                .fecha(tiempo)
                .especie(especie)
                .barco(barco)
                .caladero(caladero)
                .build();

        capturaService.guardar(captura);
    }

}
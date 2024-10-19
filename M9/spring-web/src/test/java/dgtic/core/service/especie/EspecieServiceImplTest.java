package dgtic.core.service.especie;

import dgtic.core.model.entities.EspecieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EspecieServiceImplTest {
    @Autowired
    EspecieService especieService;

    @Test
    void recuperarTest(){
        EspecieEntity especie = especieService.buscarEspecieId(1);
        System.out.println(especie.getNombre());
        System.out.println(especie.getLote().getFecha());
        System.out.println(especie.getTipo().getNombre());

    }

//    @Test
//    void borrar(){
//        especieService.borrar(1);
//    }
}
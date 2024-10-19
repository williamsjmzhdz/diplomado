package dgtic.core.service.compra;

import dgtic.core.model.entities.CompraEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompraServiceImplTest {

    @Autowired
    private CompraService compraService;

    @Test
    void recupera() {
        CompraEntity compra = compraService.buscarCompraId(1);
        System.out.println(compra.getComprador().getNombre());
        System.out.println(compra.getLote().getEspecie().iterator().next().getImagen());
    }

}
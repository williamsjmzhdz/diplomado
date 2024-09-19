package dgtic.core;

import dgtic.core.excepcion.CreditosInvalidosException;
import dgtic.core.modelo.Estudiante;
import dgtic.core.modelo.Materia;
import dgtic.core.servicio.ServicioDAO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Random;

@SpringBootTest(classes = { PruebaTest.class })
@ComponentScan("dgtic.core")
public class PruebaTest {

    @Autowired
    private ServicioDAO servicioDAO;

    private int lista[];

    @BeforeAll
    public static void unicoInicio() {
        System.out.println("Unica vez al inicio");
    }

    @BeforeEach
    public void inicio() {
        System.out.println("Antes de cada método.");
        Random rd=new Random();
        int limite=rd.nextInt(3)+1;
        lista=new int[limite];
        for(int i=0;i<limite;i++) {
            lista[i]=i;
        }



    }

    @AfterAll
    public static void unicoFinal() {
        System.out.println("Unica vez al final");
    }

    @AfterEach
    public void despues() {
        System.out.println("Después de cada método.");
    }

    @Test
    void testUno() {
        String esperando = "Spring";
        String actual = "Spring";
        Assertions.assertEquals(esperando, actual, "Cadenas no iguales.");
    }

    @Test
    void testDos() {
        int[] esperado = {0, 1, 2};
        Assertions.assertArrayEquals(esperado, lista);
    }

    @Test
    void testTres() {
        Estudiante estudiante = null;
        Assertions.assertNull(estudiante);
        estudiante = new Estudiante("123", "Demo", 20);
        Assertions.assertNotNull(estudiante);
    }

    @Test
    void testCuatro() {
        Estudiante valorActual = new Estudiante("234", "Raul", 18);
        Estudiante valorEsperado = new Estudiante("234", "Raul", 18);
        Estudiante valorEsperadoTemp = valorEsperado;
        //Assertions.assertSame(valorEsperado, valorActual);
        //Assertions.assertSame(valorEsperado, valorEsperadoTemp);
        //Assertions.assertNotSame(valorEsperado, valorActual);
        Assertions.assertEquals(valorEsperado, valorActual);
    }

    @Test
    void testCinco() {
        Estudiante estudiante = servicioDAO.getBaseDeDatosDAO().getEstudiante("ico", "123");
        System.out.println("LLEGHO AQUI");
        String esperando = "Lógica";
        Assertions.assertEquals(esperando, estudiante.getMaterias().stream()
                .filter(dato->dato.getNombre().equals("Lógica"))
                .findFirst().get().getNombre(),"Primero");

        /*Assertions.assertTrue(estudiante.getMaterias().stream()
                .filter(dato->dato.getNombre().equals("Lógica"))
                .findFirst().isPresent(),"Log"); */
        /*Assertions.assertTrue(estudiante.getMaterias().stream()
                .anyMatch(dato->dato.getNombre().equals("Lógica")));*/
        /*Assertions.assertFalse(estudiante.getMaterias().stream()
                .anyMatch(dato->dato.getNombre().equals("Lógica")));*/
    }

    @Test
    void testSeis() {
        Estudiante est = servicioDAO.getBaseDeDatosDAO().getEstudiante("ico", "123");
        String esperado = "Lógica";

        Assertions.assertAll(
                // Primera aserción: Verificar que la materia "Lógica" está presente y tiene el nombre esperado
                () -> Assertions.assertEquals(esperado,
                        est.getMaterias().stream()
                                .filter(dato -> dato.getNombre().equals("Lógica"))
                                .findFirst()
                                .get().getNombre()
                ),

                // Segunda aserción: Verificar que la materia con nombre "Lógica" está presente
                () -> Assertions.assertTrue(
                        est.getMaterias().stream()
                                .filter(dato -> dato.getNombre().equals("Lógica"))
                                .findFirst()
                                .isPresent()
                ),

                // Tercera aserción: Verificar que existe una materia con el nombre "Lógica"
                () -> Assertions.assertTrue(
                        est.getMaterias().stream()
                                .anyMatch(dato -> dato.getNombre().equals("Lógica"))
                )
        );
    }

    @Test
    @DisplayName("testSiete")
    void testSiete() {
        Materia materia = new Materia("Algebra", 23);
        Exception exp = Assertions.assertThrows(CreditosInvalidosException.class, () -> {
            materia.setCreditos(-20);
        });
        String actual = exp.getMessage();
        String esperado = "Créditos inválidos.";
        // verdadero, se prueba el error
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    void testOcho() {
        Estudiante estUno = servicioDAO.getBaseDeDatosDAO().getEstudiante("ico", "123");
        Estudiante estDos = servicioDAO.getBaseDeDatosDAO().getEstudiante("ico", "124");
        //Sin implementar equals en Materia
        //Assertions.assertIterableEquals(estUno.getMaterias(), estDos.getMaterias());
        //sin implementar equals en Materia
        estDos.getMaterias().add(0, new Materia("Cálculo",9));
        Assertions.assertIterableEquals(estUno.getMaterias(), estDos.getMaterias());
        //implementado equals
        //estDos.getMaterias().add(0, new Materia("Cálculo",9));
        //Assertions.assertIterableEquals(estUno.getMaterias(), estDos.getMaterias());
    }

    @Test
    void testNueve() {
        Assertions.assertTimeout(java.time.Duration.ofSeconds(2), ()->{
            Thread.sleep(1000);
        });
    }

}

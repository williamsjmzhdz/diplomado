package mx.unam.dgtic.config;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class SiteConfigTest  {

    public void setUp() throws Exception {
    }

    @Test
    public void whenCreateASiteConfigAndIsSingleton(){
        //Given
        SiteConfig config=SiteConfig.getInstance();

        //When
        config.setSiteName("Test Website");
        config.setTheme("DARK");
        config.setEnableNotifications(true);

        //Then
        assertNotNull(config);
        assumeTrue("Singleton Testing",SiteConfig.getInstance()!=null);
        assertTrue(config.equals(SiteConfig.getInstance()));

    }
}
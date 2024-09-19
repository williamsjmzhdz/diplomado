package mx.unam.dgtic.factory;

import junit.framework.TestCase;
import mx.unam.dgtic.products.BloodTest;
import mx.unam.dgtic.products.XRayMachine;
import mx.unam.dgtic.products.abstractProducts.ClinicalTest;
import mx.unam.dgtic.products.abstractProducts.Device;
import org.junit.Assert;
import org.junit.Test;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class XRayFactoryTest {

    @Test
    public void givenXRayFactoryWhenCreateNewDeviceThenValidateThatIsXRay() {
        //GIVEN
        XRayFactory factory = new XRayFactory();

        //WHEN
        Device device = factory.createDevice();

        //THEN
        Assert.assertNotNull(device);
        Assert.assertTrue(device instanceof XRayMachine);
    }

    @Test
    public void givenXRayFactoryWhenCreateNewClinicalTestThenValidateThatIsBloodTest() {
        //GIVEN
        XRayFactory factory = new XRayFactory();

        //WHEN
        ClinicalTest clinicalTest = factory.createClinicalTest();

        //THEN
        Assert.assertNotNull(clinicalTest);
        Assert.assertTrue(clinicalTest instanceof BloodTest);
    }

}
package mx.unam.dgtic.factory;

import mx.unam.dgtic.products.MRI;
import mx.unam.dgtic.products.UrineTest;
import mx.unam.dgtic.products.abstractProducts.ClinicalTest;
import mx.unam.dgtic.products.abstractProducts.Device;
import org.junit.Assert;
import org.junit.Test;


/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class MRIFactoryTest {
    @Test
    public void givenMRIFactoryWhenCreateNewDeviceThenValidateThatIsAMRI() {
        //GIVEN
        MRIFactory factory = new MRIFactory();

        //WHEN
        Device device = factory.createDevice();

        //THEN
        Assert.assertNotNull(device);
        Assert.assertTrue(device instanceof MRI);
    }

    @Test
    public void givenMRIFactoryWhenCreateNewClinicalTestThenValidateThatIsAMRI() {
        //GIVEN
        MRIFactory factory = new MRIFactory();

        //WHEN
        ClinicalTest clinicalTest = factory.createClinicalTest();

        //THEN
        Assert.assertNotNull(clinicalTest);
        Assert.assertTrue(clinicalTest instanceof UrineTest);
    }
}
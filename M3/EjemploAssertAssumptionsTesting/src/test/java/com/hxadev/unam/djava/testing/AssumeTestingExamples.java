package com.hxadev.unam.djava.testing;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * @author: hxa.dev
 */
public class AssumeTestingExamples {
    @Test
    public void testAssumptionTrue(){
        int result=5*2;
        Assume.assumeTrue("Asumption true",result==10);
        assertEquals(10,result);
    }

    @Test
    public void testAssumptionFalse(){
        int result=5*2;
        Assume.assumeFalse("Asumption false",result==120);
        assertEquals(10,result);
    }

    @Test
    public void testAssumptionNotNull(){
        Integer result=5*2;
        Assume.assumeNotNull(result);
        assertNotNull(result);
    }
}

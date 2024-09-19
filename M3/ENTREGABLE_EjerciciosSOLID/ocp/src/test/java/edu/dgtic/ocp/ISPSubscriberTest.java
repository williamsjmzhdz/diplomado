package edu.dgtic.ocp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ISPSubscriberTest {
    private ISPSubscriber ispSubscriber = null;

    @BeforeEach
    public void init() {
        InternetSessionHistory.addSession(1L, LocalDateTime.now(), 500L);
        ispSubscriber = new ISPSubscriber();
    }

    @Test
    public void testClass(){
        ispSubscriber.setSubscriberId(1L);
        ispSubscriber.setAddress("Avenida siempre viva");
        ispSubscriber.setBaseRate(10);
        ispSubscriber.setFreeUsage(0);
        ispSubscriber.setPhoneNumber(55155555L);
        System.out.println(ispSubscriber.calculateBill());
        assertEquals(ispSubscriber.calculateBill(), 50.0);
    }
}
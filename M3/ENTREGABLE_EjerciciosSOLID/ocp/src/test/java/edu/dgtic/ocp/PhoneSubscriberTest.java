package edu.dgtic.ocp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PhoneSubscriberTest {
    private PhoneSubscriber phoneSubscriber = null;

    @BeforeEach
    public void init() {
        CallHistory.addSession(2L, LocalDateTime.now(), 600L);
        phoneSubscriber = new PhoneSubscriber();
    }

    @Test
    public void testClass(){
        phoneSubscriber.setSubscriberId(2L);
        phoneSubscriber.setAddress("Avenida siempre viva");
        phoneSubscriber.setBaseRate(20);
        phoneSubscriber.setPhoneNumber(66166666L);
        System.out.println(phoneSubscriber.calculateBill());
        assertEquals(phoneSubscriber.calculateBill(), 120.0);
    }
}
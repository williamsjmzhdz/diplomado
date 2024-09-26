package tech.hxadev.unam.controller.factory;

import tech.hxadev.unam.entities.Request;

public interface RequestFactory {
    Request createRequest(String prompt);
}

package tech.hxadev.unam.controller.factory;

import tech.hxadev.unam.entities.Request;

public class ImageRequestFactory implements RequestFactory {
    @Override
    public Request createRequest(String prompt) {
        return Request.builder()
                .prompt(prompt)
                .aspect_ratio("1:1")
                .build();
    }
}

package tech.hxadev.unam.controller.factory;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import tech.hxadev.unam.client.AIGeneratorClient;
import tech.hxadev.unam.client.decoders.GeneratorErrorDecorder;
import tech.hxadev.unam.util.PropertiesUtil;

public interface ClientFactory {
    AIGeneratorClient generateClient();
}

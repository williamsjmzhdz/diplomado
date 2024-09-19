package tech.hxadev.unam.controller.factory;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import tech.hxadev.unam.client.AIGeneratorClient;
import tech.hxadev.unam.client.decoders.GeneratorErrorDecorder;
import tech.hxadev.unam.util.PropertiesUtil;

public class AIClientGeneratorFactory implements ClientFactory {

    private PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();

    @Override
    public AIGeneratorClient generateClient() {
        return Feign
                .builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .errorDecoder(new GeneratorErrorDecorder(new GsonDecoder()))
                .requestInterceptor(template -> {
                    template.header("Authorization", "Bearer " + propertiesUtil.getPropertyCore("openapi.dalle.apikey"))
                            .header("X-Api-Version", "v1");
                })
                .target(AIGeneratorClient.class, propertiesUtil.getPropertyCore("openapi.dalle.baseurl"));
    }
}

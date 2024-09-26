package tech.hxadev.unam.controller;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import tech.hxadev.unam.client.AIGeneratorClient;
import tech.hxadev.unam.client.decoders.GeneratorErrorDecorder;
import tech.hxadev.unam.controller.factory.AIClientGeneratorFactory;
import tech.hxadev.unam.controller.factory.ImageRequestFactory;
import tech.hxadev.unam.entities.DataRequest;
import tech.hxadev.unam.entities.GenerationInfo;
import tech.hxadev.unam.entities.ImageDAO;
import tech.hxadev.unam.entities.Request;
import tech.hxadev.unam.entities.Response;
import tech.hxadev.unam.model.ImagesModel;
import tech.hxadev.unam.util.FilesUtil;
import tech.hxadev.unam.util.PropertiesUtil;
/**
 * @author <a href="https://github.com/hxadev">HXADEV</a>
 * @since 1.0
 */
public class ImageGeneratorControllerImpl implements ImageGeneratorController {

    private ImagesModel model;
    private ImageRequestFactory imageRequestFactory;
    private AIClientGeneratorFactory aiClientGeneratorFactory;

    public ImageGeneratorControllerImpl() {
        this.imageRequestFactory = new ImageRequestFactory();
        this.aiClientGeneratorFactory = new AIClientGeneratorFactory();
        this.model = new ImagesModel();
    }

    @Override
    public void generateImage(GenerationInfo info) {
        if (Optional.ofNullable(info).isEmpty() || info.getPrompt().isEmpty()) {
            throw new RuntimeException("El prompt está vacio");
        }

        Response response = aiClientGeneratorFactory.generateClient()
                .generateImagesDalleByPrompt(imageRequestFactory.createRequest(info.getPrompt()));

        if (Optional.of(response.getData()).isEmpty()
                || !Optional.of(response.getCreated()).isPresent()) {
            throw new RuntimeException("Error al generar la imagen");

        }

        saveImagesDalle(response.getData(), info.getPrompt());
        model.addImage(new ImageDAO(info.getPrompt(), response.getData().get(0).getAsset_url(), new Date()));
    }

    private void saveImagesDalle(List<DataRequest> data, String prompt) {
        File directory = new File(FilesUtil.parsePromptToFolderName(prompt));
        data
                .stream()
                .filter(result -> Optional.of(result).isPresent())
                .map(image -> image.getAsset_url())
                .forEach(urlImage -> {
                    try (InputStream is = new URL(urlImage).openStream()) {
                        if (!directory.exists()) {
                            directory.mkdirs();
                        }
                        Files.copy(is, Paths
                                .get(directory.getPath() + File.separator
                                        + FilesUtil.parsePromptToImageName(prompt)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
    }

    @Override
    public void addImage(ImageDAO image) {
        model.addImage(image);
    }

    @Override
    public ImageDAO getFirstImage() {
        return model.getFirstImage();
        
    }

    @Override
    public List<ImageDAO> getImages() {
        return model.getImages();
    }

    @Override
    public ImageDAO getImageByPromp(String prompt) {
        return model.getImageByPrompt(prompt);
        
    }

    


}

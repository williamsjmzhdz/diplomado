package tech.hxadev.unam.view.strategy;

import tech.hxadev.unam.controller.ImageGeneratorController;

public class DisplayImageStrategy implements MenuStrategy {
    private ImageGeneratorController controller;

    public DisplayImageStrategy(ImageGeneratorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getImages().stream().forEach(image -> {
            System.out.println("Image Name:" + image.getName() +
                    " Image URL:" + image.getUrl() +
                    " Image Creation Date:" + image.getCreated());
        });
    }
}

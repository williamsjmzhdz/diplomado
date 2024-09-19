package tech.hxadev.unam.view.strategy;

import tech.hxadev.unam.controller.ImageGeneratorController;
import tech.hxadev.unam.entities.ImageDAO;
import java.util.Scanner;

public class DisplayImagesByPromptStrategy implements MenuStrategy {
    private ImageGeneratorController controller;

    public DisplayImagesByPromptStrategy(ImageGeneratorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(">> Ingresa el prompt de la imagen que quieres obtener ");
        System.out.print(">> ");
        String prompt = new Scanner(System.in).nextLine();

        ImageDAO image = controller.getImageByPromp(prompt);

        if (image == null) {
            System.out.println("¡¡¡¡¡ No se encontro la imagen con el prompt !!!!!!! :  " + prompt);
        } else {
            System.out.println("Image Name:" + image.getName() +
                    " Image URL:" + image.getUrl() +
                    " Image Creation Date:" + image.getCreated());
        }
    }
}

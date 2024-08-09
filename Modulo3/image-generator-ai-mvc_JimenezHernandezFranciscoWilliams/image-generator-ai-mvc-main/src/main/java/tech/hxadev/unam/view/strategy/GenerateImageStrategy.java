package tech.hxadev.unam.view.strategy;

import tech.hxadev.unam.controller.ImageGeneratorController;
import tech.hxadev.unam.entities.GenerationInfo;
import java.util.Scanner;

public class GenerateImageStrategy implements MenuStrategy {
    private ImageGeneratorController controller;

    public GenerateImageStrategy(ImageGeneratorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(">> Ingresa el prompt de la imagen que quieres generar");
        System.out.print(">> ");
        String prompt = new Scanner(System.in).nextLine();

        controller.generateImage(GenerationInfo.builder().prompt(prompt).build());
    }
}

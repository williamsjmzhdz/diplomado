package tech.hxadev.unam.view;

import java.util.Scanner;

import tech.hxadev.unam.controller.ImageGeneratorController;
import tech.hxadev.unam.controller.ImageGeneratorControllerImpl;
import tech.hxadev.unam.view.strategy.GenerateImageStrategy;
import tech.hxadev.unam.view.strategy.DisplayImageStrategy;
import tech.hxadev.unam.view.strategy.DisplayImagesByPromptStrategy;
import tech.hxadev.unam.view.strategy.MenuStrategy;

/**
 * @author <a href="https://github.com/hxadev">HXADEV</a>
 * @since 1.0
 */
public class ImageGeneratorView {
    private GenerateImageStrategy generateImageStrategy;
    private DisplayImageStrategy displayImageStrategy;
    private DisplayImagesByPromptStrategy displayImagesByPromptStrategy;

    public ImageGeneratorView(ImageGeneratorController controller) {
        this.generateImageStrategy = new GenerateImageStrategy(controller);
        this.displayImageStrategy = new DisplayImageStrategy(controller);
        this.displayImagesByPromptStrategy = new DisplayImagesByPromptStrategy(controller);
    }

    public void run() {
        try {
            int centinel = 0;
            int option = 1;

            do {
                this.banner();
                option = new Scanner(System.in).nextInt();

                MenuStrategy strategy = null;

                switch (option) {
                    case 1:
                        strategy = generateImageStrategy;
                        break;
                    case 2:
                        strategy = displayImageStrategy;
                        break;
                    case 3:
                        strategy = displayImagesByPromptStrategy;
                        break;
                    case 0:
                        System.out.println("Hasta Luego");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

                if (strategy != null) {
                    strategy.execute();
                }

            } while (option != centinel);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void banner() {
        System.out.println("\n+++ Generador de imagenes utilizando AI +++");
        System.out.println("\n+++ Selecciona la opcion que deseas utilizar +++");
        System.out.println("\n+++ 1) Generar imagen - 2) Mostrar historial - 3) Obtener Imagen por prompt - 0) Salir +++");
    }
}

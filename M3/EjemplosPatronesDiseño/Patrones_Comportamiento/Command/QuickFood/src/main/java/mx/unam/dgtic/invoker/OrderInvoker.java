package mx.unam.dgtic.invoker;

import mx.unam.dgtic.command.Command;

/**
 * Unidad 3 - Principios y Patrones de Diseño
 *
 * @author: hxa.dev
 */
public class OrderInvoker {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    // ExecuteCommand
    public void pressButton() {
        command.execute();
    }
}

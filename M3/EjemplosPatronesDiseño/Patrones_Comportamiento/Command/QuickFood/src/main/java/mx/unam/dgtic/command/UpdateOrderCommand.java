package mx.unam.dgtic.command;

import mx.unam.dgtic.models.Order;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class UpdateOrderCommand implements Command{
    private Order order;

    public UpdateOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setStatus("UPDATED");
        System.out.println("STATUS: "+order.getStatus());
    }
}

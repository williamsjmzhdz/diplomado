package mx.unam.dgtic.command;

import mx.unam.dgtic.models.Order;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class CreateOrderCommand implements Command{
    private Order order;

    public CreateOrderCommand(Order order) {
        this.order = order;
        System.out.println("INITIAL STATUS: "+order.getStatus());

    }

    @Override
    public void execute() {
        order.setStatus("CREATED");
        System.out.println("STATUS: "+order.getStatus());
    }
}

package mx.unam.dgtic.command;

import mx.unam.dgtic.models.Order;

public class FinishingOrderCommand implements Command{

    private Order order;

    public FinishingOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setStatus("FINISHED");
        System.out.println("STATUS: "+order.getStatus());
    }


}

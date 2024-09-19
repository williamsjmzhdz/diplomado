package mx.unam.dgtic.command;

import mx.unam.dgtic.models.Order;

public class PreparingCommand implements Command {
    private Order order;

    public PreparingCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setStatus("PREPARING");
        System.out.println("STATUS: "+order.getStatus());
        
    }
    
    
}

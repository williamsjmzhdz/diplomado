package mx.unam.dgtic;

import mx.unam.dgtic.command.Command;
import mx.unam.dgtic.command.CreateOrderCommand;
import mx.unam.dgtic.command.FinishingOrderCommand;
import mx.unam.dgtic.command.PreparingCommand;
import mx.unam.dgtic.command.UpdateOrderCommand;
import mx.unam.dgtic.invoker.OrderInvoker;
import mx.unam.dgtic.models.Order;

public class app {
    public static void main(String[] args) {

        Order order = new Order("Hamburguesa", "McDonalds", null, "hxa.dev", 0.0, "DEFAULT");

        Command createCommand = new CreateOrderCommand(order);
        Command updateCommand = new UpdateOrderCommand(order);
        Command prepareCommand = new PreparingCommand(order);
        Command finishCommand=new FinishingOrderCommand(order);

        OrderInvoker invoker = new OrderInvoker();
        invoker.setCommand(createCommand);
        invoker.pressButton();
        invoker.setCommand(updateCommand);
        invoker.pressButton();
        invoker.setCommand(prepareCommand);
        invoker.pressButton();
        invoker.setCommand(finishCommand);
        invoker.pressButton();

    }
}

package be.vdab.beerhouse.services;

import be.vdab.beerhouse.domain.Order;
import be.vdab.beerhouse.domain.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {

    Order create(OrderSaveCommand command) {
        Order order = new Order();
        order.setName(command.getName());
        order.setStreet(command.getStreet());
        order.setHouseNr(command.getHouseNr());
        order.setPostcode(command.getPostcode());
        order.setMunicipality(command.getMunicipality());
        return order;
    }

    OrderItem createOrderItem(OrderItemCreateCommand item, long orderId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(orderId);
        orderItem.setBeerId(item.getBeerId());
        orderItem.setAmount(item.getAmount());
        orderItem.setPrice(item.getPrice());
        return orderItem;
    }
}

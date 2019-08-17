package be.vdab.beerhouse.services;

import be.vdab.beerhouse.domain.Order;
import be.vdab.beerhouse.repositories.OrderItemRepository;
import be.vdab.beerhouse.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultOrderService implements OrderService {


    private final OrderFactory factory;
    private final OrderRepository repository;
    private final OrderItemRepository itemRepository;

    public DefaultOrderService(OrderRepository repository, OrderItemRepository itemRepository, OrderFactory factory) {
        this.itemRepository = itemRepository;
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public long save(OrderSaveCommand command) {
        Order order = factory.create(command);
        long orderId = repository.save(order);
        command.getItems().stream()
                .map(item -> factory.createOrderItem(item, orderId))
                .forEach(itemRepository::save);
        return orderId;
    }

    @Override
    public void saveItem() {

    }
}

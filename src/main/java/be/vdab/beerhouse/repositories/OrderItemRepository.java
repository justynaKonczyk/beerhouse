package be.vdab.beerhouse.repositories;


import be.vdab.beerhouse.domain.OrderItem;

public interface OrderItemRepository {
    void save(OrderItem orderItem);
}

package be.vdab.beerhouse.repositories;


import be.vdab.beerhouse.domain.Order;

public interface OrderRepository {

    long save(Order order);
}

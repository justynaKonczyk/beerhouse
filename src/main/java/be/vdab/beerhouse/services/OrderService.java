package be.vdab.beerhouse.services;


public interface OrderService {

    long save(OrderSaveCommand command);
    void saveItem();
}

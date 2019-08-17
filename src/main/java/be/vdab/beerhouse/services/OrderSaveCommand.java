package be.vdab.beerhouse.services;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderSaveCommand {

    private String name;
    private String street;
    private String houseNr;
    private int postcode;
    private String municipality;
    private List<OrderItemCreateCommand> items;

}

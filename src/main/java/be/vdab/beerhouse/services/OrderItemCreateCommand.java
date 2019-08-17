package be.vdab.beerhouse.services;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderItemCreateCommand {

    private long beerId;
    private long amount;
    private BigDecimal price;

}

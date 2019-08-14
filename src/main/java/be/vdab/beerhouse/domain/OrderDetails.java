package be.vdab.beerhouse.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private long lineItemId;
    private long beerId;
    private long amount;
    private BigDecimal price;

    public OrderDetails(long lineItemId, long beerId,
                        long amount, BigDecimal price) {
        this.lineItemId = lineItemId;
        this.beerId = beerId;
        this.amount = amount;
        this.price = price;
    }

    public long getLineItemId() {
        return lineItemId;
    }

    public long getBeerId() {
        return beerId;
    }

    public long getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

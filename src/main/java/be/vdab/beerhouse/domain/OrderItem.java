package be.vdab.beerhouse.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private long orderId;
    private long beerId;
    private long amount;
    private BigDecimal price;

    public long getOrderId() {
        return orderId;
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

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setBeerId(long beerId) {
        this.beerId = beerId;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

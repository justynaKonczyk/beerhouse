package be.vdab.beerhouse.sessions;

import be.vdab.beerhouse.domain.Beer;

import java.math.BigDecimal;

public class CartItem {

    private Beer beer;
    private BigDecimal amount;
    private BigDecimal subtotal;

    public CartItem(Beer beer, BigDecimal amount, BigDecimal subtotal) {
        this.subtotal = subtotal;
        this.amount = amount;
        this.beer = beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Beer getBeer() {
        return beer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }
}

package be.vdab.beerhouse.forms;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class BeerForm {

    @NotNull
    @PositiveOrZero
    private final BigDecimal amount;

    public BeerForm(@NotNull @PositiveOrZero BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

package be.vdab.beerhouse.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class Beer {

    private final long id;

    @NotBlank
    private  final String name;

    @NotNull
    @PositiveOrZero
    private final long brouwerId;

    @NotNull
    @PositiveOrZero
    private final long soortId;

    @NotNull
    @PositiveOrZero
    private final BigDecimal price;

    @NotNull
    @PositiveOrZero
    private final BigDecimal alcohol;

    @NotNull
    @PositiveOrZero
    private final long ordered;

    public Beer(long id, @NotBlank String name, @NotNull @PositiveOrZero long brouwerId,
                @NotNull @PositiveOrZero long soortId, @NotNull @PositiveOrZero BigDecimal price,
                @NotNull @PositiveOrZero BigDecimal alcohol, @NotNull @PositiveOrZero long ordered) {
        this.id = id;
        this.name = name;
        this.brouwerId = brouwerId;
        this.soortId = soortId;
        this.price = price;
        this.alcohol = alcohol;
        this.ordered = ordered;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getBrouwerId() {
        return brouwerId;
    }

    public long getSoortId() {
        return soortId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public long getOrdered() {
        return ordered;
    }
}

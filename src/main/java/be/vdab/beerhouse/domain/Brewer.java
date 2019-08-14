package be.vdab.beerhouse.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Brewer {


    private final long id;

    @NotBlank
    private final String name;

    @NotBlank
    private final String street;

    @NotBlank
    private final String houseNr;

    @NotNull
    @PositiveOrZero
    private final int postcode;

    @NotBlank
    private final String municipality;

    @NotNull
    @PositiveOrZero
    private final long sales;

    public Brewer(long id, @NotBlank String name, @NotBlank String street,
                  @NotBlank String houseNr, @NotNull @PositiveOrZero int postcode,
                  @NotBlank String municipality, @NotNull @PositiveOrZero long sales) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.houseNr = houseNr;
        this.postcode = postcode;
        this.municipality = municipality;
        this.sales = sales;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public long getSales() {
        return sales;
    }
}

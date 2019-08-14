package be.vdab.beerhouse.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String houseNr;

    private int postcode;

    @NotBlank
    private String municipality;

    public Order(long id, @NotBlank String name, @NotBlank String street,
                 @NotBlank String houseNr, int postcode,
                 @NotBlank String municipality) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.houseNr = houseNr;
        this.postcode = postcode;
        this.municipality = municipality;
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
}

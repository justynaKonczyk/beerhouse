package be.vdab.beerhouse.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartForm {

    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private  String houseNr;

    @NotNull
    @Min(1000)
    @Max(9999)
    private int postcode;

    @NotBlank
    private String gemeente;


    public CartForm(@NotBlank String name, @NotBlank String street, @NotBlank String houseNr,
                    @NotNull @Min(1000) @Max(9999) int postcode, @NotBlank String gemeente) {
        this.name = name;
        this.street = street;
        this.houseNr = houseNr;
        this.postcode = postcode;
        this.gemeente = gemeente;
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

    public String getGemeente() {
        return gemeente;
    }
}

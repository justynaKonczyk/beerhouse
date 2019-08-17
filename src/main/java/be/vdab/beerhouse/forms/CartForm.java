package be.vdab.beerhouse.forms;

import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
public class CartForm {

    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String houseNr;

    @NotNull
    @Min(1000)
    @Max(9999)
    private int postcode;

    @NotBlank
    private String gemeente;

    public CartForm() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }
}

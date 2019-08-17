package be.vdab.beerhouse.domain;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    private String street;

    private String houseNr;

    private int postcode;

    private String municipality;

    public Order() {
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

    public void setId(long id) {
        this.id = id;
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

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
}

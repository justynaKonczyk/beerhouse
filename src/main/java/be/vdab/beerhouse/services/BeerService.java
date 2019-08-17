package be.vdab.beerhouse.services;

import be.vdab.beerhouse.domain.Beer;

import java.util.List;

public interface BeerService {

    List<Beer> findAllByBreweryId(long id);
    Beer findByBeerId(long id);
    List<Beer> findAll();


}

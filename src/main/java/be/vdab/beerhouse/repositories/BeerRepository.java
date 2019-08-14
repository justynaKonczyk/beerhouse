package be.vdab.beerhouse.repositories;

import be.vdab.beerhouse.domain.Beer;

import java.util.List;

public interface BeerRepository {

    List<Beer> findAllByBreweryId(long breweryId);
    Beer findBeerById(long beerId);
    List<Beer> findAll();
    long insert(Beer beer);
    long update(Beer beer);
    long delete(Beer beer);
}
